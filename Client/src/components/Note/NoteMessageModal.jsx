import { useState } from "react";
import Button from "../Common/Button.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";

const MessageModal = ({ isOpen, onClose, onSend }) => {
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setMessage(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSend(message);
    setMessage("");
    onClose();
  };

  // if (!isOpen) return null;

  return (
    <div>
      <PageTitle pageTitle="쪽지" />
      <section>
        <dl>
          <dt>오늘 보낸 쪽지</dt>
          <dd> 0/50</dd>
        </dl>
        <dl>
          <dt>받는 친구</dt>
          <dd> 생크림맛우유 </dd>
        </dl>
      </section>
      <section>
        <form onSubmit={handleSubmit}>
          <textarea value={message} onChange={handleChange} />
        </form>
      </section>

      <Button type="submit">보내기</Button>
      <Button variant="lightbtn" onClick={onClose}>
        닫기
      </Button>
    </div>
  );
};
export default MessageModal;
