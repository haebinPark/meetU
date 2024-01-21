import { useState } from "react";
import pb from "../../api/pocketbase.js";
import MemberLayout from "../../layout/MemberLayout.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import MyPageSection from "../../components/MyPage/MyPageSection.jsx";
import MyPageProfile from "../../components/MyPage/MyPageProfile.jsx";
import MyPageChangeInfo from "../../components/MyPage/MyPageChangeInfo.jsx";
import DivisionLine from "../../components/MyPage/DivisionLine.jsx";
import MyPageNoBand from "../../components/MyPage/MyPageNoBand.jsx";
import MyPageRecommend from "../../components/MyPage/MyPageRecommend.jsx";
import MyPageFriendList from "../../components/MyPage/MyPageFriendList.jsx";
import getNofity from "../../utils/getNotify";

const friendsList = [
  {
    userId: "useId01",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te31",
    styleCode: "#f4eeee",
  },
  {
    userId: "useId02",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄22",
    styleCode: "#faebdd",
  },
  {
    userId: "useId03",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄",
    styleCode: "#fbf3db",
  },
  {
    userId: "useId04",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te40",
    styleCode: "#edf3ec",
  },
  {
    userId: "useId05",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te56",
    styleCode: "#e7f3f8",
  },
  {
    userId: "useId06",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te72",
    styleCode: "#f6f3f9",
  },
  {
    userId: "useId07",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te85",
    styleCode: "#faf1f5",
  },
  {
    userId: "useId08",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te99",
    styleCode: "#faf1f5",
  },
  {
    userId: "useId09",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄T106",
    styleCode: "#fdebec",
  },
  {
    userId: "useId10",
    interests: ["SOCCER", "CODING", "MUSIC"],
    nickName: "미츄Te11",
    styleCode: "#f6f3f9",
  },
];

function MyPage() {
  const [userInfo, setUserInfo] = useState(pb.authStore.model);
  const [openColorPalette, setOpenColoPalette] = useState(false);

  async function postColor() {
    const userId = pb.authStore.model.id;
    const data = { styleCode: userInfo.styleCode };
    await pb.collection("users").update(userId, data);
    await pb.collection("users").authRefresh();
  }

  function handleColorChange(e) {
    e.preventDefault();
    if (!openColorPalette) {
      setOpenColoPalette(!openColorPalette);
      return;
    }
    postColor();
    getNofity("success", "색상이 변경되었습니다.");
    setOpenColoPalette(!openColorPalette);
  }

  function handleStyleCode(e) {
    const { value } = e.target;
    setUserInfo({ ...userInfo, styleCode: value });
  }

  return (
    <MemberLayout>
      <PageTitle>마이페이지</PageTitle>
      {/* 프로필 */}
      <MyPageSection sectionTite="프로필">
        <MyPageProfile userInfo={userInfo} />
      </MyPageSection>
      {/* 회원정보 수정, 색상 변경 */}
      <MyPageSection sectionTite="회원정보 수정" height="7rem">
        <MyPageChangeInfo
          selectedColor={userInfo.styleCode}
          openColorPalette={openColorPalette}
          handleColorChange={handleColorChange}
          handleStyleCode={handleStyleCode}
        />
      </MyPageSection>
      {/* 구분선 */}
      <DivisionLine />
      {userInfo.band === "" ? (
        <MyPageNoBand />
      ) : (
        <MyPageSection sectionTite="친구 추천">
          <MyPageRecommend>
            <MyPageFriendList interest="MBTI" friendsList={friendsList} />
            <MyPageFriendList interest="코딩" friendsList={friendsList} />
            <MyPageFriendList interest="봉사활동" friendsList={friendsList} />
            <MyPageFriendList interest="음악" friendsList={friendsList} />
          </MyPageRecommend>
        </MyPageSection>
      )}
    </MemberLayout>
  );
}

export default MyPage;
