import { styled } from "styled-components";
import Header from "./components/layout/Header.jsx";
import Footer from "./components/layout/Footer.jsx";

const Main = styled.main`
  min-height: 100%;
  padding-bottom: 8rem;
`;

function App() {
  return (
    <>
      <Header />
      <Main>메인</Main>
      <Footer />
    </>
  );
}

export default App;
