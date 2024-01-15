import { styled } from "styled-components";
import getNotify from "../../utils/getNotify";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState } from "react";

const CommentEntry = styled.ul`
  /* 방명록 항목에 대한 스타일 */
  border-bottom: 2px solid var(--box-gray);
  width: 95%;
  padding: 3px;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 3px;
  display: grid;
  grid-template-columns: auto 1fr auto auto;
  grid-template-areas: "name comment button date";

  @media screen and (max-width: 768px) {
    grid-template-areas:
      "name name date date"
      "comment comment button button";
  }
`;

const CommentNameStyle = styled.li`
  /* 방명록 이름에 대한 스타일 */
  font-weight: 700;
  font-size: 1rem;
  grid-area: name;
`;

const CommentStyle = styled.li`
  /* 방명록 내용에 대한 스타일 */
  font-size: 1rem;
  padding-left: 1rem;
  grid-area: comment;
`;

const CommentDateStyle = styled.li`
  /* 방명록 날짜에 대한 스타일 */
  font-size: 0.6rem;
  padding-left: 10px;
  opacity: 0.5;
  color: var(--font-gray);
  text-align: right;
  grid-area: date;
`;
const ButtonStyle = styled.div`
  /* 수정 및 삭제 버튼에 대한 스타일 */
  grid-area: button;
  display: flex;
  align-items: center;
`;
const EditButton = styled.button`
  /* 수정 버튼에 대한 스타일 */
  font-size: 0.6rem;
  color: var(--font-gray);
  opacity: 0.5;
  margin-left: 10px;
`;

const DeleteButton = styled.button`
  /* 삭제 버튼에 대한 스타일 */
  font-size: 0.6rem;
  color: var(--font-red);
  opacity: 0.5;
  margin-left: 10px;
`;

const GuestComment = ({ id, nickName, contexts, date, onEdit, onDelete }) => {
  const [isSelected, setIsSelected] = useState(false);

  const parsedDate = new Date(date).toLocaleDateString("ko-kr");

  const ComHanldeEdit = () => {
    setIsSelected(true);
    onEdit(id);
  };
  const ComHandleDelete = () => {
    onDelete(id);
    getNotify("success", "삭제되었습니다!");
  };
  return (
    <>
      <CommentEntry
        style={{ backgroundColor: isSelected ? "lightgray" : "white" }}
      >
        <CommentNameStyle> {nickName} </CommentNameStyle>
        <CommentStyle> {contexts}</CommentStyle>
        <ButtonStyle>
          <EditButton onClick={ComHanldeEdit}>Edit</EditButton>
          <DeleteButton onClick={ComHandleDelete}>x</DeleteButton>
        </ButtonStyle>
        <CommentDateStyle>{parsedDate}</CommentDateStyle>
      </CommentEntry>
      <ToastContainer />
    </>
  );
};

export default GuestComment;
