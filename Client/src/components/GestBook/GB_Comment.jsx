import { styled } from "styled-components";
const CommentEntry = styled.dl`
  /* 방명록 항목에 대한 스타일 */
  border-bottom: 2px solid Var(--box-gray);
  width: 90%;
  height: 4vh;
  padding: 3px;
  margin-left: 30px;
  margin-right: 30px;
  margin-top: 3px;
  display: flex;
  justify-items: center;
  align-items: center;
  flex-direction: column;
  flex-direction: row;
`;

const CommentNameStyle = styled.dt`
  /* 방명록 이름에 대한 스타일 */
  font-weight: 700;
  font-size: 1rem;
  flex: 0.5;
`;

const CommentStyle = styled.dd`
  /* 방명록 내용에 대한 스타일 */
  display: flex;
  flex: 1;
  font-size: 1rem;
  padding-left: 1rem;
`;
const CommentDateStyle = styled.dd`
  /* 방명록 항목 내용에 대한 스타일 */
  font-size: 0.8rem;
  color: var(--font-gray);
  text-align: right;
  flex: 1;
`;
const Gestcomment = () => {
  return (
    <CommentEntry>
      <CommentNameStyle> 오우예씨몬 </CommentNameStyle>
      <CommentStyle>마치고 피방ㄱ?</CommentStyle>
      <CommentDateStyle>2024.03.04.10:36</CommentDateStyle>
    </CommentEntry>
  );
};
export default Gestcomment;
