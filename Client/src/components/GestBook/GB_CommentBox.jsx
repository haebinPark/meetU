import { styled } from "styled-components";
import Gestcomment from "./GB_Comment.jsx";
import Pagination from "../Common/Pagination.jsx";
const GBViewStyle = styled.section`
  margin-top: 10px;
  padding: 10px;
  border: 1px solid var(--font-lightgray);
  width: 100%;
  height: auto;
`;

function GestBookView() {
  return (
    <GBViewStyle>
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Gestcomment />
      <Pagination />
    </GBViewStyle>
  );
}

export default GestBookView;
