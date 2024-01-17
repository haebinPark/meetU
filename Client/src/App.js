import { Outlet } from "react-router-dom";
import PageLayout from "./layout/PageLayout.jsx";
import { ToastContainer } from "react-toastify";

function App() {
  return (
    <>
      <PageLayout>
        <Outlet />
        {/* 토스트 알림 */}
        <ToastContainer />
      </PageLayout>
    </>
  );
}

export default App;
