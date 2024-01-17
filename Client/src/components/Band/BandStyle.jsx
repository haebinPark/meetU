import { styled } from "styled-components";

export const SearchSection = styled.section`
  display: flex;
  align-items: center;
  justify-content: stretch;
`;

export const SearchForm = styled.form`
  display: flex;
  align-items: center;
`;
export const SearchSchoolInput = styled.input`
  border: 1px solid var(--brand-color);
  margin-left: 10px;
  padding: 5px;
  width: 50%;
  margin-top: 20px;
  margin-bottom: 10px;
`;

export const SearchInput = styled.input`
  border: 1px solid var(--brand-color);
  margin-left: 10px;
  padding: 5px;
  width: 20%;
`;

export const SelectBox = styled.select`
  border: 1px solid var(--brand-color);
  margin-left: 10px;
  padding: 5px;
  border-radius: 5px;
`;
