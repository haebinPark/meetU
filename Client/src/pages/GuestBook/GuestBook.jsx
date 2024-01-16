import TextContainer from "../../components/GestBook/GB_TextBar.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import GestBookView from "../../components/GestBook/GB_CommentBox.jsx";
import PageDescription from "../../components/Common/PageDescription.jsx";
function GuestBook() {
  return (
    <>
      <div style={{ textAlign: "center" }}>
        <PageTitle>방명록</PageTitle>
        <PageDescription> 짧은 글로 반 친구들과 소통해보세요! </PageDescription>
      </div>
      <TextContainer />
      <GestBookView />
    </>
  );
}

export default GuestBook;
