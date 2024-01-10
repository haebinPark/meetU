import { Mobile } from "../../layout/MediaQuery.jsx";
import { useState } from "react";
import MemberLayout from "../../layout/MemberLayout.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import MemberForm from "../../components/Member/MemberForm.jsx";
import MemberFormInput from "../../components/Member/MemeberFormInput.jsx";
import MemberFormBlock from "../../components/Member/MemberFormBlock.jsx";
import MemberErrorText from "../../components/Member/MemberErrorText.jsx";
import PageDescription from "../../components/Common/PageDescription.jsx";
import MemberFormRadio from "../../components/Member/MemberFormRadio.jsx";
import MemberFormCheckbox from "../../components/Member/MemberFormCheckbox.jsx";
import MemberFormButtonBlock from "../../components/Member/MemberFormButtonBlock.jsx";
import getNofity from "../../utils/getNotify.js";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Join() {
  const [formState, setFormState] = useState({
    email: "",
    password: "",
    passwordConfirm: "",
    nickname: "",
    mbti: "",
    interests: ["음악", "영화", "운동"],
  });

  // 에러 메세지 상태
  const [emailError, setEmailError] = useState({
    isError: false,
    errorMessage: "이메일 형식으로 입력해주세요.",
  });
  const [passwordError, setPasswordError] = useState({
    isError: false,
    errorMessage: "영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~20 자리",
  });
  const [passwordConfirmError, setPasswordConfirmError] = useState({
    isError: false,
    errorMessage: "비밀번호가 일치하지 않습니다.",
  });
  const [nicknameError, SetNicknameError] = useState({
    isError: false,
    errorMessage: "한글, 영문, 숫자 조합 2~6자리(특수문자 불가)",
  });

  // 관심사 선택
  const handleIntersts = (value) => {
    const interestSet = new Set([...formState.interests]);
    let interestArray = [];

    if (interestSet.has(value)) {
      interestSet.delete(value);
    } else if (interestSet.size >= 3) {
      getNofity("error", "관심사는 3개 까지만 선택 가능합니다.");
    } else {
      interestSet.add(value);
    }
    interestArray = [...interestSet];
    return interestArray;
  };

  // input 입력
  const handelInput = (e) => {
    const { name, value } = e.target;
    console.log(value);

    if (name === "interests") {
      const addedInterests = handleIntersts(value);
      setFormState({ ...formState, [name]: addedInterests });
    } else {
      setFormState({ ...formState, [name]: value });
    }
  };
  console.log(formState);

  // 에러 핸들링
  const handleDebounceInput = () => {};
  const handleJoin = (e) => e.preventDefault();

  return (
    <MemberLayout>
      <PageTitle pageTitle="회원가입" />
      <PageDescription>
        닉네임과 이메일로 미츄를 시작하세요! <br />
        MBTI와 관심사를 설정하시면
        <Mobile>
          <br />
        </Mobile>
        친구를 추천해 드립니다.
      </PageDescription>
      <MemberForm onSubmit={handleJoin}>
        {/* 이메일 */}
        <MemberFormBlock>
          <MemberFormInput
            type="email"
            name="email"
            label="이메일"
            defaultValue={formState.email}
            placeholder="example@email.com"
            description="관심사를 1 ~ 3개 선택해주세요."
            duplicationCheck={true}
            onChange={handelInput}
          />
          <MemberErrorText $isError={emailError.isError}>
            {emailError.errorMessage}
          </MemberErrorText>
        </MemberFormBlock>
        {/* 비밀번호 */}
        <MemberFormBlock $minHeight="15.7rem" $marginBottom="0rem">
          <MemberFormInput
            type="password"
            name="password"
            label="비밀번호"
            defaultValue={formState.password}
            placeholder="비밀번호"
            duplicationCheck={false}
            onChange={handelInput}
          />
          <MemberErrorText $isError={passwordError.isError}>
            {passwordError.errorMessage}
          </MemberErrorText>

          {/* 비밀번호 확인*/}
          <MemberFormInput
            name="passwordConfirm"
            label="비밀번호확인"
            defaultValue={formState.passwordConfirm}
            placeholder="비밀번호 확인"
            duplicationCheck={false}
            onChange={handelInput}
          />
          {passwordConfirmError.isError && (
            <MemberErrorText $isError={passwordConfirmError.isError}>
              {passwordConfirmError.errorMessage}
            </MemberErrorText>
          )}
        </MemberFormBlock>
        {/* 닉네임*/}
        <MemberFormBlock>
          <MemberFormInput
            name="nickname"
            label="닉네임"
            defaultValue={formState.nickname}
            placeholder="닉네임"
            duplicationCheck={true}
            onChange={handelInput}
          />
          <MemberErrorText $isError={nicknameError.isError}>
            {nicknameError.errorMessage}
          </MemberErrorText>
        </MemberFormBlock>
        {/* MBTI */}
        <MemberFormBlock>
          <MemberFormRadio isChecked={formState.mbti} onChange={handelInput} />
        </MemberFormBlock>
        {/* 관심사 */}
        <MemberFormBlock>
          <MemberFormCheckbox
            checkedList={formState.interests}
            onChange={handelInput}
          />
        </MemberFormBlock>
        {/* 회원가입 버튼 */}
        <MemberFormButtonBlock onClick={handleJoin} />
      </MemberForm>
      <ToastContainer />
    </MemberLayout>
  );
}

export default Join;
