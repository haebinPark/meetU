import { useState } from "react";
import getNotify from "../../utils/getNotify";
import "react-toastify/dist/ReactToastify.css";
import Button from "../Common/Button.jsx";

const BandJoin = ({ band }) => {
  const [classJoined, setClassJoined] = useState(false); // 반 가입 상태

  const handleJoinClick = () => {
    setClassJoined(true); // 반 가입 버튼 클릭 시 상태를 true로 변경
    getNotify("success", "반 가입이 완료되었습니다.");
  };

  const handleCreateClick = () => {
    //createBand(band); // 반 생성 함수 호출 (API컴포넌트 만들기)
    getNotify("success", "반 생성이 완료되었습니다.");
  };

  return (
    band && (
      <>
        {band.status === "개설중" && <Button disabled>반 개설중</Button>}
        {band.status === "생성필요" && (
          <Button onClick={handleCreateClick}>반 생성하기</Button>
        )}
        {band.status === "가입가능" &&
          (!classJoined ? (
            <Button onClick={handleJoinClick}>반 가입하기</Button>
          ) : (
            <p>반 가입 완료</p>
          ))}
      </>
    )
  );
};

export default BandJoin;
