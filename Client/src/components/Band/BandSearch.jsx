import Button from "../Common/Button.jsx";
import { styled } from "styled-components";

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
  return (
    <SearchSection>
      <SearchForm>
        <label htmlFor="schoolName">학교명 </label>
        <SearchSchoolInput type="search" id="schoolName" />
      </SearchForm>
      <SelectBox>
        <option value="초등학교"> 초등학교 </option>
        <option value="중학교">중학교</option>
        <option value="고등학교">고등학교</option>
      </SelectBox>
      <SearchForm>
        <SearchInput type="search" id="grade"></SearchInput>
        <label htmlFor="grade"> 학년 </label>
      </SearchForm>
      <SearchForm>
        <SearchInput type="search" id="class"></SearchInput>
        <label htmlFor="class"> 반 </label>
      </SearchForm>
      <Button size="sm">검색</Button>
    </SearchSection>
  );
};
export default BandSearch;
