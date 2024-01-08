import { Outlet } from "react-router-dom";
import PageLayout from "./layout/PageLayout.jsx";

function App() {
  return (
    <>
      <PageLayout>
        <Outlet />
      </PageLayout>
    </>
  );
}

export default App;
