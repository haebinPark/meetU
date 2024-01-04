import { styled } from "styled-components";
import Navigation from "./Navigation.jsx";
import HeaderTitle from "./HeaderTitle.jsx";
import { useState } from "react";

const StyledHeader = styled.header`
  border-bottom: 1px solid var(--font-lightgray);
  padding: 0rem 2rem;
  height: 4rem;
  display: flex;
  justify-content: space-between;
`;

function Header() {
  const [isAuth, setIsAuth] = useState(true);
  return (
    <StyledHeader>
      <HeaderTitle />
      {isAuth && <Navigation />}
    </StyledHeader>
  );
}

export default Header;
