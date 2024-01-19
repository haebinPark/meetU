import { styled } from "styled-components";
import Header from "./Header.jsx";
import Footer from "./Footer.jsx";
import Navigation from "./Navigation.jsx";

const Main = styled.main`
  // 모바일(기본) 레이아웃
  width: 100%;
  min-height: 100%;
  padding: 3rem;
  padding-bottom: 11rem;
  margin-left: auto;
  margin-right: auto;

  // 데스크탑 레이아웃
  @media screen and (min-width: 1024px) {
    max-width: 840px;
  }
`;

function PageLayout({ children }) {
  return (
    <>
      <Header>
        <Navigation />
      </Header>
      <Main>{children}</Main>
      <Footer />
    </>
  );
}

export default PageLayout;
