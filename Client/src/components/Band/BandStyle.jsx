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

export const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

export const TableHeader = styled.th`
  border: 1px solid #fff;
  padding: 8px;
  text-align: center;
  color: #fff;
  background-color: var(--brand-color);
`;

export const TableRow = styled.tr`
  &:nth-child(even) {
    background-color: #f2f2f2;
  }
`;

export const TableCell = styled.td`
  border: 1px solid var(--brand-color);
  padding: 8px;
  text-align: center;
`;
