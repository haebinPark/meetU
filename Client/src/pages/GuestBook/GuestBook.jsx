import PageTitle from "../../components/Common/PageTitle.jsx";
import axios from "axios";
import PageDescription from "../../components/Common/PageDescription.jsx";
import Pagination from "../../components/Common/Pagination.jsx";

import Gestcomment from "../../components/GestBook/GB_Comment.jsx";
import TextInput from "../../components/GestBook/GB_TextBox.jsx";
import Button from "../../components/Common/Button.jsx";
import { styled } from "styled-components";
import { useState, useEffect } from "react";

import getNofity from "../../utils/getNotify.js";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

//스타일//
const TextContainSt = styled.section`
  margin-top: 10px;
  width: 100%;
  border: 2px solid var(--box-gray);
  background: #ebf1e6;
  text-align: end;
`;
const GBViewStyle = styled.ul`
  margin-top: 10px;
  padding: 10px;
  border: 1px solid var(--font-lightgray);
  width: 100%;
  height: auto;
`;

axios.defaults.baseURL = "https://most-application.pockethost.io/";

function GuestBook() {
  const [text, setText] = useState("");
  const [comments, setComments] = useState([]);
  const userId = localStorage.getItem("userId");
  const [page, setPage] = useState(1);
  const pageSize = window.innerWidth <= 768 ? 10 : 15; // 모바일일 때는 10개, 웹사이트일 때는 15개

  useEffect(() => {
    axios
      .get(`api/collections/comment/records?expand=userId&perpage=${pageSize}`)
      .then((response) => {
        const sortedComments = response.data.items.reverse(); // 역순 정렬
        setComments(sortedComments);
      })
      .catch((error) => console.error(error));
  }, [page, pageSize]);

  const ComHandleSumbmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post("api/collections/comments/records", {
        contexts: text,
      });
      if (response.status === 200) {
        setText("");
        getNofity("success", "글이 등록되었습니다.");
        axios
          .get(`api/collections/comments/records`)
          .then((response) => {
            const sortedComments = response.data.items.reverse(); // 역순 정렬
            console.log(sortedComments);
          })
          .catch((error) => console.error(error));
      }
    } catch (error) {
      console.error("글을 등록하는 도중 오류가 발생했습니다:", error);
    }
  };

  const ComHandleChange = (event) => {
    setText(event.target.value);
  };

  const handleDelete = (userId) => {
    setComments(comments.filter((items) => items.id === userId.contexts.id));
  };
  return (
    <>
      <div style={{ textAlign: "center" }}>
        <PageTitle>방명록</PageTitle>
        <PageDescription> 짧은 글로 반 친구들과 소통해보세요! </PageDescription>
      </div>
      <section>
        {/* 방명록 작성부분 */}
        <TextContainSt>
          <form onSubmit={ComHandleSumbmit}>
            <TextInput
              border="1px solid var(--brand-color)"
              maxLength="200"
              onChange={ComHandleChange}
              value={text}
              width="100%"
              placeholder="글을 적어주세요!"
            />
            <Button
              type="submit"
              margin="2px 5px 0px 0px"
              onClick={ComHandleSumbmit}
            >
              등록
            </Button>
          </form>
        </TextContainSt>
        <ToastContainer />
      </section>
      <section>
        {/*  방명록 조회 부분 */}
        <GBViewStyle>
          {comments.map((comment) => (
            <Gestcomment
              key={comment.id}
              id={comment.id}
              nickName={comment.expand.userId.nickname}
              contexts={comment.contexts}
              created={comment.created}
              onDelete={handleDelete}
            />
          ))}
        </GBViewStyle>
        <Pagination
          page={page}
          pageSize={pageSize}
          totalItems={comments.length}
          onPageChange={setPage}
        />
      </section>
    </>
  );
}

export default GuestBook;
