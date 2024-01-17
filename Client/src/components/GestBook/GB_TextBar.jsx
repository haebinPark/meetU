import { styled } from "styled-components";
import Button from "../Common/Button.jsx";
import TextInput from "./GB_TextBox.jsx";
import { useState } from "react";
import axios from "axios";
import getNofity from "../../utils/getNotify.js";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const TextContainSt = styled.section`
  margin-top: 10px;
  width: 100%;
  border: 2px solid var(--box-gray);
  background: #ebf1e6;
  text-align: end;
`;

const TextContainer = () => {
  const [text, setText] = useState("");

  const ComHandleSumbmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post("http://localhost:3009/comment", {
        contexts: text,
      });
      if (response.status === 200) {
        setText("");
        getNofity("success", "글이 등록되었습니다.");
      }
    } catch (error) {
      console.error("글을 등록하는 도중 오류가 발생했습니다:", error);
    }
  };
  const ComHandleChange = (event) => {
    setText(event.target.value);
  };
  return (
    <>
      <TextContainSt>
        <form onChange={ComHandleSumbmit}>
          <TextInput
            border="1px solid var(--brand-color)"
            maxLength="200"
            onChange={ComHandleChange}
            value={text}
          />
          <Button type="submit" margin="2px 5px 0px 0px">
            등록
          </Button>
        </form>
      </TextContainSt>
      <ToastContainer />
    </>
  );
};
export default TextContainer;
