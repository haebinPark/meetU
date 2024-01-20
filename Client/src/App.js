import { RouterProvider } from "react-router-dom";
import router from "./routes";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Suspense } from "react";

function App() {
  return (
    <Suspense fallback="...loading">
      <RouterProvider router={router} />
      {/* 토스트 알림 */}
      <ToastContainer />
    </Suspense>
  );
}

export default App;
