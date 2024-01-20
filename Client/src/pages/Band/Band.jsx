import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import PageDescription from "../../components/Common/PageDescription.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";

import getNotify from "../../utils/getNotify";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";

//반검색
import {
  SearchSection,
  TableCell,
  TableRow,
  TableHeader,
  Table,
} from "../../components/Band/BandStyle.jsx";
import SchoolSearchForm from "../../components/Band/SchoolSearchForm.jsx";
import GradeSearchForm from "../../components/Band/GradeSearchForm.jsx";
import ClassSearchForm from "../../components/Band/ClassSearchForm.jsx";
import SchoolTypeSelect from "../../components/Band/SchoolTypeSelect.jsx";
import SearchButton from "../../components/Band/BandSearchButton.jsx";

//반생성가입
import {
  BandRequestButton,
  BandJoinButton,
} from "../../components/Band/BandFunction.jsx";

function Band() {
  //반 검색 상태관리//
  const [schoolInput, setSchoolInput] = useState("");
  const [gradeInput, setGradeInput] = useState("");
  const [classInput, setClassInput] = useState("");
  const [schoolType, setSchoolType] = useState("초등학교");
  const [searchResult, setSearchResult] = useState([]);
  const nickname = localStorage.getItem("nickname");

  //반 가입 상태관리//
  const [isBand, setIsBand] = useState(false);
  const navigate = useNavigate();
  // 검색에 필요한 데이터를 `reqDate` 객체에 담는다.
  const reqDate = {
    school: schoolInput,
    schoolType,
    grade: gradeInput,
    banNum: classInput,
  };
  const handleSearchClick = async (event) => {
    event.preventDefault();
    try {
      // 서버로부터 데이터를 받아온다.
      const { items } = await axios.get(
        "https://aeng0908.pockethost.io/api/collections/bands/records",
      );
      if (items.status === 200) {
        // 검색 결과를 상태로 업데이트한다.
        setSearchResult(items);
        // `isBand` 상태를 업데이트합니다.
        setIsBand(true);
      } else {
        getNotify("error", "검색에 실패하였습니다.");
      }
    } catch (error) {
      console.error("검색 오류", error);
      getNotify("error", "검색오류가 발생했습니다");
    }
  };

  async function handleRequestClick(event) {
    event.preventDefault();
    try {
      const data = {
        nickName: nickname,
        reqDate,
      };
      const response = await axios.post("api/collections/bands/records", data);
      if (response.data.success) {
        getNotify("success", "개설 요청이 완료되었습니다.");
      } else {
        getNotify("error", "개설 요청에 실패하였습니다.");
      }
    } catch (error) {
      console.error("개설 요청 중 오류 발생:", error);
      getNotify("error", "개설 요청 중 오류가 발생하였습니다.");
    }
  }
  async function handleJoinClick(event) {
    event.preventDefault();
    try {
      const result = await axios.post("api/collections/bands/records"); // 서버에 가입 요청

      if (result.success) {
        getNotify("success", "가입이 완료되었습니다.");
        navigate("/guestbook");
      }
    } catch (error) {
      "가입오류", error;
    }
    getNotify("error", "가입에 실패하였습니다.");
  }
  return (
    <>
      <section style={{ textAlign: "center" }}>
        <PageTitle>반 검색</PageTitle>
        <PageDescription>우리 반을 찾아보세요!</PageDescription>
        <SearchSection onSubmit={handleSearchClick}>
          <SchoolSearchForm
            schoolInput={schoolInput}
            setSchoolInput={setSchoolInput}
          />
          <SchoolTypeSelect
            schoolType={schoolType}
            setSchoolType={setSchoolType}
          />
          <GradeSearchForm
            gradeInput={gradeInput}
            setGradeInput={setGradeInput}
          />
          <ClassSearchForm
            classInput={classInput}
            setClassInput={setClassInput}
          />
          <SearchButton type="submit" onClick={handleSearchClick} />
        </SearchSection>
      </section>
      <section>
        <PageTitle>반 목록</PageTitle>
        <Table>
          <thead>
            <TableRow>
              <TableHeader>검색결과</TableHeader>
              <TableHeader>개설상태</TableHeader>
            </TableRow>
          </thead>
          <tbody>
            <TableRow>
              <TableCell>
                {isBand ? (
                  `${schoolInput}${schoolType} ${gradeInput}학년 ${classInput}반`
                ) : (
                  <span style={{ color: "#999999" }}>검색 결과 없음</span>
                )}
              </TableCell>
              <TableCell>
                <>
                  {isBand ? (
                    <BandJoinButton onClick={handleJoinClick}>
                      반 가입하기
                    </BandJoinButton>
                  ) : (
                    <BandRequestButton onClick={handleRequestClick}>
                      반 개설하기
                    </BandRequestButton>
                  )}
                </>
              </TableCell>
            </TableRow>
          </tbody>
        </Table>
      </section>
      <ToastContainer />
    </>
  );
}

export default Band;
