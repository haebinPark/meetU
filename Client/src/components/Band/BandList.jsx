import { styled } from "styled-components";
import BandJoin from "./BandJoin.jsx";

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const TableHeader = styled.th`
  border: 1px solid #fff;
  padding: 8px;
  text-align: center;
  color: #fff;
  background-color: var(--brand-color);
`;

const TableRow = styled.tr`
  &:nth-child(even) {
    background-color: #f2f2f2;
  }
`;

const TableCell = styled.td`
  border: 1px solid var(--brand-color);
  padding: 8px;
`;

const BandList = ({ bands }) => {
  return (
    <Table>
      <thead>
        <TableRow>
          <TableHeader>검색결과</TableHeader>
          <TableHeader>개설상태</TableHeader>
        </TableRow>
      </thead>
      <tbody>
        <TableRow>
          <TableCell>미츄고등학교 3학년 1반 </TableCell>
          <TableCell>
            <BandJoin />
          </TableCell>
        </TableRow>
      </tbody>
    </Table>
  );
};

export default BandList;
