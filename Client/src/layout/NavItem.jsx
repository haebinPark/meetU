import { styled } from "styled-components";
import { Link } from "react-router-dom";

const StyledNavItem = styled.li`
  color: var(--font-gray);

  /* 마우스 hover 또는 선택 시 */
  &:hover,
  &:focus-within,
  &.seleted-nav {
    color: var(--brand-color);
    text-decoration: underline;
    font-weight: 500;
  }
`;

function NavItem({ link, menuName, className }) {
  return (
    <>
      <StyledNavItem className={className}>
        <Link to={link}>{menuName}</Link>
      </StyledNavItem>
    </>
  );
}

export default NavItem;
