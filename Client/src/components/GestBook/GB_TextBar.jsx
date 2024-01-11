import { styled } from "styled-components";
import Button from "../Common/Button.jsx";
import TextInput from "./GB_TextBox.jsx";

const TextContainSt = styled.section`
  width: 100%;
  border: 2px solid var(--box-gray);
  background: #ebf1e6;
  text-align: end;
`;

const TextContainer = ({ onSubmit }) => {
  return (
    <TextContainSt>
      <TextInput maxLength="200" />
      <Button margin="2px 5px 0px 0px" onClick={onSubmit}>
        등록
      </Button>
    </TextContainSt>
  );
};
export default TextContainer;
