import { styled } from "styled-components";
import { Link } from "react-router-dom";

const StyledNavItem = styled.li`
  color: var(--font-gray);

  /* 마우스 hover 시 */
  &:hover,
  &:focus-within {
    color: var(--brand-color);
    text-decoration: underline;
    font-weight: 500;
  }
`;

function NavItem({ link, menuName }) {
  return (
    <>
      <StyledNavItem>
        <Link to={link}>{menuName}</Link>
      </StyledNavItem>
    </>
  );
}

export default NavItem;
