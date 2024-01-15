import { styled } from "styled-components";

const StyledNavList = styled.ul`
  height: 100%;
  display: flex;
  align-items: center;
  gap: 1.5rem;
  background-color: white;
  z-index: 1;

  /* 모바일 버전 */
  @media screen and (max-width: 767px) {
    display: none;
    width: 13rem;
    height: auto;
    border: 1px solid var(--font-lightgray);
    padding: 1rem;
    font-size: 1.3rem;

    /* 모바일 버전 위치 */
    position: absolute;
    right: 0rem;
    top: 3rem;

    &.openNav {
      display: block;
    }
  }
`;

function NavList({ className, children }) {
  return (
    <StyledNavList className={className ? "openNav" : ""}>
      {children}
    </StyledNavList>
  );
}

export default NavList;
