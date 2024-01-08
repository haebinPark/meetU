import { styled } from "styled-components";
import Header from "./Header.jsx";
import Footer from "./Footer.jsx";

const Main = styled.main`
  // 모바일(기본) 레이아웃
  width: 100%;
  min-height: 100%;
  padding: 3rem;
  margin-left: auto;
  margin-right: auto;

  // 데스크탑 레이아웃
  @media screen and (min-width: 1024px) {
    max-width: 840px;
  }
`;

const Section = styled.section`
  width: 100%;
  height: 100vh;
  background-color: beige;
`;

function PageLayout({ children }) {
  return (
    <>
      <Header />
      <Main>
        <Section>{children}</Section>
      </Main>
      <Footer />
    </>
  );
}

export default PageLayout;
