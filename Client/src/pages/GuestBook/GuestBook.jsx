import TextInput from "../../components/GestBook/GB_TextBox.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import GestBookView from "../../components/GestBook/GB_CommentBox.jsx";
function GuestBook() {
  return (
    <main>
      <PageTitle pageTitle="방명록" />
      <TextInput />
      <GestBookView />
    </main>
  );
}

export default GuestBook;
