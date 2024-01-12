import { styled } from "styled-components";
import Button from "../Common/Button.jsx";
import TextInput from "./GB_TextBox.jsx";
import { useState } from "react";

const TextContainSt = styled.section`
  width: 100%;
  border: 2px solid var(--box-gray);
  background: #ebf1e6;
  text-align: end;
`;

const TextContainer = ({ onSubmit }) => {
  const [text, setText] = useState("");

  const ComHandleSumbmit = (event) => {
    event.preventDefult();
    onSubmit(text);
    setText("");
  };
  const ComHandleChange = (event) => {
    setText(event.target.value);
  };
  return (
    <TextContainSt>
      <form onSubmit={ComHandleSumbmit}>
        <TextInput maxLength="200" onChange={ComHandleChange} value={text} />
        <Button type="submit" margin="2px 5px 0px 0px">
          등록
        </Button>
      </form>
    </TextContainSt>
  );
};
export default TextContainer;
