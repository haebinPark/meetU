import Button from "../Common/Button.jsx";
import { styled } from "styled-components";

//택스트박스CSS
const TextInputStyled = styled.input`
  width: 100%;
  height: 8vh;
  padding: 20px;
  border: 2px solid var(--brand-sub-color);
  border-bottom: hidden;
  border-radius: 4px;
  font-size: 1rem;
  overflow: auto;
  white-space: normal;
`;

//텍스트바CSS
const TextbarStyled = styled.div`
  width: 100%;
  height: 47px;
  border-bottom: 2px solid var(--brand-sub-color);
  border-left: 2px solid var(--brand-sub-color);
  border-top: 2px solid var(--box-gray);
  background-color: #d1e1ca87;
  align-items: center;
  display: flex;
  justify-content: space-between;
`;
const ButtonWrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: flex-end;
`;

const TextInput = ({ value, onChange }) => {
  return (
    <>
      <TextInputStyled
        type="text"
        value={value}
        onChange={onChange}
        placeholder="글을 적어 보세요"
      />
      <TextbarStyled>
        <ButtonWrapper>
          <Button>등록</Button>
        </ButtonWrapper>
      </TextbarStyled>
    </>
  );
};

export default TextInput;
