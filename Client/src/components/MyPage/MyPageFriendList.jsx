import { styled } from "styled-components";
import NickNameTag from "./NickNameTag.jsx";

const RecomendTitle = styled.dt`
  font-weight: 500;
`;

const FriendWrapper = styled.div`
  width: 100%;
  display: flex;
  flex-wrap: nowrap;
  overflow-x: scroll;
  overflow-y: hidden;
  gap: 5px;
  margin-top: 1rem;
  margin-bottom: 4rem;
  padding-bottom: 10px;
`;

function MyPageFriendList({ interest, friendsList }) {
  return (
    <>
      {interest === "MBTI" ? (
        <RecomendTitle>
          나와 같은 <span>{interest}</span> 친구
        </RecomendTitle>
      ) : (
        <RecomendTitle>
          <span>{interest}</span>에 관심 있는 친구
        </RecomendTitle>
      )}

      <FriendWrapper>
        {friendsList.map((friend) => {
          return (
            <NickNameTag key={friend.userId} $styleCode={friend.styleCode}>
              {friend.nickName}
            </NickNameTag>
          );
        })}
      </FriendWrapper>
    </>
  );
}

export default MyPageFriendList;
