import { styled } from "styled-components";
import { useState } from "react";
import MemberLayout from "../../layout/MemberLayout.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import MyPageSection from "../../components/MyPage/MyPageSection.jsx";
import MyPageProfile from "../../components/MyPage/MyPageProfile.jsx";
import MyPageChangeInfo from "../../components/MyPage/MyPageChangeInfo.jsx";

const DivisionLine = styled.hr`
  width: 100%;
  border: 1px solid var(--box-gray);
`;

function MyPage() {
  const [userInfo, setUserInfo] = useState({
    userId: 12345,
    email: "user@example.com",
    nickName: "아띠Um12",
    mbti: "INTJ",
    interests: ["CODING", "TREVEL", "MUSIC"],
  });
  const [styleCode, setStyleCode] = useState("#f4eeee");
  const [openColorPalette, setOpenColoPalette] = useState(false);

  const handleColorPalette = (e) => {
    e.preventDefault();
    setOpenColoPalette(!openColorPalette);
  };

  const handleStyleCode = (e) => {
    setStyleCode(e.target.value);
  };

  return (
    <MemberLayout>
      <PageTitle pageTitle="마이페이지" />
      {/* 프로필 */}
      <MyPageSection sectionTite="프로필">
        <MyPageProfile userInfo={userInfo} styleCode={styleCode} />
      </MyPageSection>

      {/* 회원정보 수정 */}
      <MyPageSection sectionTite="회원정보 수정" height="7rem">
        <MyPageChangeInfo
          openColorPalette={openColorPalette}
          handleColorPalette={handleColorPalette}
          styleCode={styleCode}
          handleStyleCode={handleStyleCode}
        />
      </MyPageSection>

      {/* 구분선 */}
      <DivisionLine />

      {/* 친구추천 */}
      <MyPageSection sectionTite="친구 추천"></MyPageSection>
    </MemberLayout>
  );
}

export default MyPage;
