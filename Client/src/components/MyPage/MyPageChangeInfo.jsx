import { styled } from "styled-components";
import { Link } from "react-router-dom";
import Button from "../Common/Button.jsx";
import StyleCodePalette from "./StyleCodePalette.jsx";

const Ul = styled.ul`
  display: flex;
  justify-content: center;
  gap: 1rem;
  position: relative;
`;

const ButtonStyleLink = styled(Link)`
  display: block;
  width: 7rem;
  height: 3rem;
  font-weight: 500;
  color: var(--font-white);
  background-color: var(--brand-color);
  box-shadow:
    0 10px 15px -3px rgb(0 0 0 / 0.1),
    0 4px 6px -4px rgb(0 0 0 / 0.1);
  border-radius: 8px;
  text-align: center;
  line-height: 3rem;

  &:hover {
    background-color: var(--brand-sub-color);
  }
`;

function MyPageChangeInfo({
  openColorPalette,
  handleColorPalette,
  styleCode,
  handleStyleCode,
}) {
  return (
    <Ul>
      <li>
        <ButtonStyleLink to="/membership">회원정보 수정</ButtonStyleLink>
      </li>
      <li>
        <form>
          <Button
            variant="subbtn"
            type="submit"
            width="7rem"
            onClick={handleColorPalette}
          >
            {openColorPalette ? "변경 완료" : "색상 변경"}
          </Button>
          {openColorPalette && (
            <StyleCodePalette
              styleCode={styleCode}
              handleStyleCode={handleStyleCode}
            />
          )}
        </form>
      </li>
    </Ul>
  );
}

export default MyPageChangeInfo;
