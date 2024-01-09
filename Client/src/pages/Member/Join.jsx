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
import MemberFormButtonBlock from "../../components/Member/MemberFormButtonBlock.jsx";

function Join() {
  const [formState, setFormState] = useState({
    email: "",
    password: "",
    passwordConfirm: "",
    nickname: "",
    mbti: "",
    interests: "",
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
      <MemberForm handleJoin={handleJoin}>
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
          />
          <MemberErrorText $isError={nicknameError.isError}>
            {nicknameError.errorMessage}
          </MemberErrorText>
        </MemberFormBlock>
        {/* MBTI */}
        <MemberFormBlock>
          <MemberFormRadio groupType="mbti" />
        </MemberFormBlock>
        {/* 관심사 */}
        <MemberFormBlock>
          <MemberFormRadio groupType="interest" />
        </MemberFormBlock>
        {/* 회원가입 버튼 */}
        <MemberFormButtonBlock onClick={handleJoin} />
      </MemberForm>
    </MemberLayout>
  );
}

export default Join;
