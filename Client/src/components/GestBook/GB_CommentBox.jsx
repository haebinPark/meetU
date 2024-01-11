import { styled } from "styled-components";
import Gestcomment from "./GB_Comment.jsx";
const GBViewStyle = styled.ul`
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
    </GBViewStyle>
  );
}

export default GestBookView;
