import Button from "../Common/Button.jsx";
import { styled } from "styled-components";
import { useState } from "react";

const SearchSection = styled.section`
  display: flex;
  align-items: center;
  justify-content: stretch;
`;

const SearchForm = styled.form`
  display: flex;
  align-items: center;
`;
const SearchSchoolInput = styled.input`
  border: 1px solid var(--brand-color);
  margin-left: 10px;
  padding: 5px;
  width: 50%;
  margin-top: 20px;
  margin-bottom: 10px;
`;

const SearchInput = styled.input`
  border: 1px solid var(--brand-color);
  margin-left: 10px;
  padding: 5px;
  width: 20%;
`;

const SelectBox = styled.select`
  border: 1px solid var(--brand-color);
  margin-left: 10px;
  padding: 5px;
  border-radius: 5px;
`;

const BandSearch = () => {
  const [schoolInput, setSchoolInput] = useState("");
  const [gradeInput, setGradeInput] = useState("");
  const [classInput, setClassInput] = useState("");
  const [schoolType, setSchoolType] = useState("초등학교");
  const [searchResult, setSearchResult] = useState([]);

  const handleSearchClick = () => {
    // 검색 버튼 클릭 시 로직
  };

  return (
    <SearchSection>
      <SearchForm>
        <label htmlFor="schoolName">학교명 </label>
        <SearchSchoolInput
          type="search"
          id="schoolName"
          value={schoolInput}
          onChange={(e) => setSchoolInput(e.target.value)}
        />
      </SearchForm>
      <SelectBox
        value={schoolType}
        onChange={(e) => setSchoolType(e.target.value)}
      >
        <option value="초등학교"> 초등학교 </option>
        <option value="중학교">중학교</option>
        <option value="고등학교">고등학교</option>
      </SelectBox>
      <SearchForm>
        <SearchInput
          type="search"
          id="grade"
          value={gradeInput}
          onChange={(e) => setGradeInput(e.target.value)}
        />
        <label htmlFor="grade"> 학년 </label>
      </SearchForm>
      <SearchForm>
        <SearchInput
          type="search"
          id="class"
          value={classInput}
          onChange={(e) => setClassInput(e.target.value)}
        />
        <label htmlFor="class"> 반 </label>
      </SearchForm>
      <Button size="sm" onClick={handleSearchClick}>
        검색
      </Button>
    </SearchSection>
  );
};
export default BandSearch;
