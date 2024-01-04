import { styled } from "styled-components";
import { useState } from "react";
import NavButton from "./NavButton.jsx";
import NavList from "./NavList.jsx";
import NavItem from "./NavItem.jsx";

const StyledNav = styled.nav`
  @media screen and (max-width: 767px) {
    position: relative;
    align-self: center;
  }
`;

const navItems = [
  { id: 0, link: "/introduction", menuName: "소개" },
  { id: 1, link: "/band", menuName: "우리 반" },
  { id: 2, link: "/guestbook", menuName: "방명록" },
  { id: 3, link: "/note", menuName: "쪽지함" },
  { id: 4, link: "/mypage", menuName: "마이페이지" },
  { id: 5, link: "/", menuName: "로그아웃" },
  { id: 6, link: "/join", menuName: "회원가입" },
  { id: 7, link: "/login", menuName: "로그인" },
  { id: 8, link: "/membership", menuName: "회원정보 수정" },
];

function Navigation() {
  const [openNav, setOpenNav] = useState(false);

  const openNavList = () => setOpenNav(!openNav);

  return (
    <>
      <StyledNav>
        <NavButton openNavList={openNavList} className={openNav && "openNav"} />
        <NavList className={openNav && "openNav"}>
          {navItems.map((item) => (
            <NavItem key={item.id} link={item.link} menuName={item.menuName} />
          ))}
        </NavList>
      </StyledNav>
    </>
  );
}

export default Navigation;
