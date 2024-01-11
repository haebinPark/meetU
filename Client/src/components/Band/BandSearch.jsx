import { styled } from "styled-components";

import { useState } from "react";

const BandContainer = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 80%;
  height: 20px;
`;
const SearchInputStyle = styled.form`
  border: 2px solid red;
  width: 1.25rem;
  height: 1.125rem;
  margin-left: 10px;
  color: #000;
`;

const BandSearch = () => {
  const [school, setSchool] = useState("");
  const [schoolName, setSchoolName] = useState("");
  const [grade, setGrade] = useState("");
  const [clazz, setClazz] = useState("");

  const handleSchoolInputChange = (e) => {
    setSchoolName(e.target.value);
  };
  const handleSchoolChange = (selectedSchool) => {
    setSchool(selectedSchool);
  };

  const handleGradeInputChange = (e) => {
    const inputGrade = e.target.value;

    // 입력값이 숫자이고 1부터 6까지의 범위에 속할 때만 업데이트
    if (/^[1-6]$/.test(inputGrade)) {
      setGrade(inputGrade);
    }
  };

  const handleClazzInputChange = (e) => {
    setClazz(e.target.value);
  };

  return (
    <BandContainer>
      <SearchInputStyle>
        <SearchInput
          placeholder="학교이름"
          value={schoolName}
          onChange={handleSchoolInputChange}
        />
      </SearchInputStyle>

      <SearchDropdown onChange={handleSchoolChange} />
      <SearchInputStyle>
        <SearchInput
          placeholder="학년"
          value={grade}
          onChange={handleGradeInputChange}
        >
          학년
        </SearchInput>
      </SearchInputStyle>
      <SearchInputStyle>
        <SearchInput
          placeholder="반"
          value={clazz}
          onChange={handleClazzInputChange}
        >
          반
        </SearchInput>
      </SearchInputStyle>
    </BandContainer>
  );
};

const SearchDropdown = ({ onChange }) => {
  // 드롭다운 메뉴의 학교 목록을 관리하는 상태와 로직은 생략
  const schools = ["초등학교", "중학교", "고등학교"];

  return (
    <select onChange={(e) => onChange(e.target.value)}>
      {schools.map((school) => (
        <option key={school} value={school}>
          {school}
        </option>
      ))}
    </select>
  );
};

const SearchInput = ({ placeholder, value, onChange }) => {
  return (
    <input
      type="text"
      placeholder={placeholder}
      value={value}
      onChange={onChange}
    />
  );
};

export default BandSearch;
