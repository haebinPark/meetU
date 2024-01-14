import { styled } from "styled-components";
import BandJoin from "./BandJoin.jsx";
const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const TableHeader = styled.th`
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
  background-color: #f2f2f2;
`;

const TableRow = styled.tr`
  &:nth-child(even) {
    background-color: #f2f2f2;
  }
`;

const TableCell = styled.td`
  border: 1px solid #ddd;
  padding: 8px;
`;

const BandList = ({ bands }) => {
  return (
    <Table>
      <thead>
        <TableRow>
          <TableHeader>학교명</TableHeader>
          <TableHeader>학년</TableHeader>
          <TableHeader>반</TableHeader>
          <TableHeader>가입상태</TableHeader>
        </TableRow>
      </thead>
      <tbody>
        <TableRow>
          <TableCell>미츄고등학교</TableCell>
          <TableCell>2학년</TableCell>
          <TableCell>1반</TableCell>
          <TableCell>
            <BandJoin />
          </TableCell>
        </TableRow>
      </tbody>
    </Table>
  );
};

export default BandList;
