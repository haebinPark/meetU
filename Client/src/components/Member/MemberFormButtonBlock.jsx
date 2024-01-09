import { styled } from "styled-components";
import Button from "../../components/Common/Button.jsx";

const ButtonBlock = styled.div`
  text-align: center;
  margin-left: auto;
  margin-right: auto;
`;

function MemberFormButtonBlock({ onClick }) {
  return (
    <ButtonBlock>
      <Button type="submit" size="lg" onClick={onClick}>
        회원가입
      </Button>
    </ButtonBlock>
  );
}

export default MemberFormButtonBlock;
