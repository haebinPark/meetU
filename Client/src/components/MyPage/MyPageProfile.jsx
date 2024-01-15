import { styled } from "styled-components";
import HiddenTitle from "../../components/MyPage/HiddenTitle.jsx";

const Dl = styled.dl`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  color: var(--font-gray);
`;

const NickNameTag = styled.dd`
  background-color: ${({ $styleCode }) => $styleCode};
  border-radius: 20px;
  font-size: 1.8rem;
  width: 12rem;
  height: 6rem;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function MyPageProfile({ userInfo, styleCode }) {
  return (
    <Dl>
      <HiddenTitle as="dt">닉네임</HiddenTitle>
      <NickNameTag $styleCode={styleCode}>{userInfo.nickName}</NickNameTag>
      <HiddenTitle as="dt">이메일</HiddenTitle>
      <dd>{userInfo.email}</dd>
    </Dl>
  );
}

export default MyPageProfile;
