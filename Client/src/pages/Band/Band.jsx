import BandList from "../../components/Band/BandList.jsx";
import { SearchSection } from "../../components/Band/BandStyle.jsx";
import SchoolSearchForm from "../../components/Band/SchoolSearchForm.jsx";
import GradeSearchForm from "../../components/Band/GradeSearchForm.jsx";
import ClassSearchForm from "../../components/Band/ClassSearchForm.jsx";
import SchoolTypeSelect from "../../components/Band/SchoolTypeSelect.jsx";
import SearchButton from "../../components/Band/BandSearchButton.jsx";
import PageDescription from "../../components/Common/PageDescription.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import { useState } from "react";

function Band() {
  const [schoolInput, setSchoolInput] = useState("");
  const [gradeInput, setGradeInput] = useState("");
  const [classInput, setClassInput] = useState("");
  const [schoolType, setSchoolType] = useState("초등학교");
  const [searchResult, setSearchResult] = useState([]);

  const handleSearchClick = () => {
    setSearchResult([
      {
        schoolName: schoolInput,
        schoolType,
        grade: gradeInput,
        class: classInput,
      },
    ]);
  };

  return (
    <>
      <section style={{ textAlign: "center" }}>
        <PageTitle>반 검색</PageTitle>
        <PageDescription> 우리 반을 찾아보세요! </PageDescription>
        <SearchSection>
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
          <SearchButton onClick={handleSearchClick} />
        </SearchSection>
      </section>
      <section>
        <PageTitle>반 목록</PageTitle>
        <BandList bands={searchResult} />
      </section>
    </>
  );
}

export default Band;
