import { styled } from "styled-components";
import { Outlet } from "react-router-dom";
import Header from "./layout/Header.jsx";
import Footer from "./layout/Footer.jsx";

const Main = styled.main`
  min-height: 100%;
  padding: 3rem;
`;

function App() {
  return (
    <>
      <Header />
      <Main>
        <Outlet />
      </Main>
      <Footer />
    </>
  );
}

export default App;
