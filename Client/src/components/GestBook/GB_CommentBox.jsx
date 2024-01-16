import { styled } from "styled-components";
import Gestcomment from "./GB_Comment.jsx";
import Pagination from "../Common/Pagination.jsx";
import { useState, useEffect } from "react";
import axios from "axios";

axios.defaults.baseURL = "http://localhost:3009";

const GBViewStyle = styled.ul`
  margin-top: 10px;
  padding: 10px;
  border: 1px solid var(--font-lightgray);
  width: 100%;
  height: auto;
`;

function GestBookView() {
  const [comments, setComments] = useState([]);

  useEffect(() => {
    axios
      .get("/comments")
      .then((response) => setComments(response.data))
      .catch((error) => console.error(error));
  }, []);

  const handleDelete = (id) => {
    setComments(comments.filter((comment) => comment.id !== id));
  };

  return (
    <GBViewStyle>
      {comments.map((comment) => (
        <Gestcomment
          key={comment.id}
          id={comment.id}
          nickName={comment.nickName}
          contexts={comment.contexts}
          createdAt={comment.createdAt}
          onDelete={handleDelete}
        />
      ))}
      <Pagination />
    </GBViewStyle>
  );
}

export default GestBookView;
