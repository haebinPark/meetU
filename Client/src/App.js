import { Outlet } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <>
      <Outlet />
      {/* 토스트 알림 */}
      <ToastContainer />
    </>
  );
}

export default App;
