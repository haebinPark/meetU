import { styled } from "styled-components";
import hambergerIcon from "../assets/nav-hamberger.svg";
import xmarkIcon from "../assets/x-mark.svg";

const StyledNavButton = styled.button`
  display: none;

  /* 모바일 버전 */
  @media screen and (max-width: 767px) {
    display: block;
    width: 1.6rem;
    height: 2rem;
    background: no-repeat center/80%;
    background-image: url(${hambergerIcon});

    &.openNav {
      background-image: url(${xmarkIcon});
    }
  }
`;

function NavButton({ openNavList, className }) {
  return (
    <StyledNavButton
      onClick={openNavList}
      className={className ? className : ""}
      aria-label="네비게이션"
    />
  );
}

export default NavButton;
