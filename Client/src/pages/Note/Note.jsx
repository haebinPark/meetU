import PageTitle from "../../components/Common/PageTitle.jsx";
import PageDescription from "../../components/Common/PageDescription.jsx";
import MessageBox from "../../components/Note/NoteMessageList.jsx";
import MessageModal from "../../components/Note/NoteMessageModal.jsx";
function Note() {
  return (
    <>
      <div style={{ textAlign: "center" }}>
        <PageTitle pageTitle="쪽지함" />
        <PageDescription>
          반친구들과 주고받은 쪽지를 모아두었어요!
        </PageDescription>
      </div>

      <MessageBox />
      <MessageModal />
    </>
  );
}

export default Note;
