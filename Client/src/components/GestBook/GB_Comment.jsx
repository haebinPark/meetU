import { styled } from "styled-components";

const CommentEntry = styled.dl`
  /* 방명록 항목에 대한 스타일 */
  border-bottom: 2px solid var(--box-gray);
  width: 95%;
  padding: 3px;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 3px;
  display: grid;
  grid-template-columns: auto 1fr auto;
  grid-template-areas: "name comment date";

  @media screen and (max-width: 768px) {
    grid-template-areas:
      "name name date date"
      "comment comment comment comment";
  }
`;

const CommentNameStyle = styled.dt`
  /* 방명록 이름에 대한 스타일 */
  font-weight: 700;
  font-size: 1rem;
  grid-area: name;
`;

const CommentStyle = styled.dd`
  /* 방명록 내용에 대한 스타일 */
  font-size: 1rem;
  padding-left: 1rem;
  grid-area: comment;
`;

const CommentDateStyle = styled.dd`
  /* 방명록 날짜에 대한 스타일 */
  font-size: 0.6rem;
  padding-left: 10px;
  opacity: 0.5;
  color: var(--font-gray);
  text-align: right;
  grid-area: date;
`;

const GuestComment = ({ id, name, comment, date, onEdit, onDelete }) => {
  const ComHanldeEdit = () => {
    onEdit(id);
  };
  const ComHandleDelete = () => {
    onDelete(id);
  };
  return (
    <CommentEntry>
      <CommentNameStyle> 오우예씨몬 </CommentNameStyle>
      <CommentStyle>마치고 피방 ㄱ?</CommentStyle>
      <CommentDateStyle>오늘</CommentDateStyle>
    </CommentEntry>
  );
};

export default GuestComment;
