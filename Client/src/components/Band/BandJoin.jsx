import { useState } from "react";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Button from "../Common/Button.jsx";

toast.configure();

const BandJoin = ({ band }) => {
  const [classJoined, setClassJoined] = useState(false); // 반 가입 상태

  const handleJoinClick = () => {
    setClassJoined(true); // 반 가입 버튼 클릭 시 상태를 true로 변경
    toast.success("반 가입이 완료되었습니다.", {
      position: toast.POSITION.BOTTOM_RIGHT,
    });
  };

  const handleCreateClick = () => {
    createBand(band); // 반 생성 함수 호출 (API컴포넌트 만들기)
    toast.success("반 생성이 완료되었습니다.", {
      position: toast.POSITION.BOTTOM_RIGHT,
    });
  };

  return (
    band && (
      <>
        <p>{`${band.schoolName} ${band.grade}학년 ${band.class}반 검색 완료`}</p>
        {band.status === "개설중" && <Button disabled>반 개설중</Button>}
        {band.status === "생성해야함" && (
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
