import TextContainer from "../../components/GestBook/GB_TextBar.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import GestBookView from "../../components/GestBook/GB_CommentBox.jsx";
function GuestBook() {
  return (
    <main>
      <PageTitle pageTitle="방명록" />
      <TextContainer />
      <GestBookView />
    </main>
  );
}

export default GuestBook;
