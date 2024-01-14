import { styled } from "styled-components";
import BandJoin from "./BandJoin.jsx";

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const TableHeader = styled.th`
  border: 1px solid var(--brand-color);
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
  border: 1px solid var(--brand-color);
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
        {bands.map((band, index) => (
          <TableRow key={index}>
            <TableCell>{band.schoolName}</TableCell>
            <TableCell>{band.grade}</TableCell>
            <TableCell>{band.class}</TableCell>
            <TableCell>
              <BandJoin band={band} />
            </TableCell>
          </TableRow>
        ))}
      </tbody>
    </Table>
  );
};

export default BandList;
