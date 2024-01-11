import { styled } from "styled-components";

//택스트박스CSS
const TextInputStyled = styled.textarea`
  width: 100%;
  height: 60%;
  padding: 20px;
  border: ${({ $border }) => $border};
  border-radius: 4px;
  font-size: 1rem;
  overflow: auto;
  white-space: normal;
  resize: none;
`;

const TextInput = ({ value, onChange, border }) => {
  return (
    <TextInputStyled
      type="text"
      value={value}
      onChange={onChange}
      $border={border}
      placeholder="글을 적어 보세요"
    />
  );
};

export default TextInput;
