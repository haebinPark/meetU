import { SearchForm, SearchSchoolInput } from "./BandStyle.jsx";

const SchoolSearchForm = ({ schoolInput, setSchoolInput }) => (
  <SearchForm>
    <label htmlFor="schoolName">학교명 </label>
    <SearchSchoolInput
      type="search"
      id="schoolName"
      value={schoolInput}
      onChange={(e) => setSchoolInput(e.target.value)}
    />
  </SearchForm>
);

export default SchoolSearchForm;
