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
      <form onSubmit={onSubmit}>
        <TextInput maxLength="200" />
        <Button type="submit" margin="2px 5px 0px 0px">
          등록
        </Button>
      </form>
    </TextContainSt>
  );
};
export default TextContainer;
