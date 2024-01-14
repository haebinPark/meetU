import { useState } from "react";
import Button from "../Common/Button.jsx";
const BandJoin = () => {
  const [classInfo, setClassInfo] = useState(null); // 검색한 반 정보
  const [classJoined, setClassJoined] = useState(false); // 반 가입 상태

  const handleSearchClick = () => {
    setClassInfo({ calss: "1반", status: "개설중" });
  };
  const handleJoinClick = () => {
    setClassJoined(true); // 반 가입 버튼 클릭 시 상태를 true로 변경
  };
  return (
    <>
      <Button size="sm" onClick={handleClick}>
        반 생성
      </Button>
      {classCreated ? <p>반 개설중</p> : <p>반 개설신청</p>}
      {!classCreated && <Button size="sm">반 가입하기</Button>}
    </>
  );
};

export default BandJoin;
