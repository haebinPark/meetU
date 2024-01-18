import { Outlet } from "react-router-dom";
import PageLayout from "./layout/PageLayout.jsx";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

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
