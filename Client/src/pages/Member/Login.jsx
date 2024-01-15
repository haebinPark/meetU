import { useState } from "react";

import MemberLayout from "../../layout/MemberLayout.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";
import PageDescription from "../../components/Common/PageDescription.jsx";
import MemberForm from "../../components/Member/MemberForm.jsx";
import MemberFormBlock from "../../components/Member/MemberFormBlock.jsx";
import MemberFormInput from "../../components/Member/MemeberFormInput.jsx";
import MemberErrorText from "../../components/Member/MemberErrorText.jsx";
import MemberFormButtonBlock from "../../components/Member/MemberFormButtonBlock.jsx";
import Button from "../../components/Common/Button.jsx";
import MemberQuestionBlock from "../../components/Member/MemberQuestionBlock.jsx";

function Login() {
  const [formState, setFormState] = useState({ email: "", password: "" });

  // 에러 메세지 상태
  const [emailError, setEmailError] = useState({
    isError: false,
    errorMessage: "이메일은 반드시 입력해야합니다.",
  });
  const [passwordError, setPasswordError] = useState({
    isError: false,
    errorMessage: "비밀번호는 반드시 입력해야합니다.",
  });

  const handleInput = () => {};
  const handleLogin = () => {};

  return (
    <MemberLayout>
      <PageTitle>로그인</PageTitle>
      <PageDescription>
        로그인을 하시려면 <br /> 이메일과 비밀번호를 입력해주세요.
      </PageDescription>
      <MemberForm onSubmit={handleLogin}>
        {/* 이메일 */}
        <MemberFormBlock $minHeight="7rem" $marginBottom="1rem">
          <MemberFormInput
            type="email"
            name="email"
            label="이메일"
            defaultValue={formState.email}
            placeholder="example@email.com"
            onChange={handleInput}
          />
          {emailError.isError && (
            <MemberErrorText $isError={emailError.isError}>
              {emailError.errorMessage}
            </MemberErrorText>
          )}
        </MemberFormBlock>

        {/* 비밀번호 */}
        <MemberFormBlock $minHeight="8rem" $marginBottom="4rem">
          <MemberFormInput
            type="password"
            name="password"
            label="비밀번호"
            defaultValue={formState.password}
            placeholder="비밀번호"
            duplicationCheck={false}
            onChange={handleInput}
          />
          {passwordError.isError && (
            <MemberErrorText $isError={passwordError.isError}>
              {passwordError.errorMessage}
            </MemberErrorText>
          )}
        </MemberFormBlock>

        {/* 로그인 버튼 */}
        <MemberFormButtonBlock $marginBottom="4rem">
          <Button type="submit" size="lg" onClick={handleLogin}>
            로그인
          </Button>
        </MemberFormButtonBlock>

        {/* 비밀번호 찾기 링크 */}
        <MemberQuestionBlock
          question="비밀번호를 잊어버리셨나요?"
          linkText="비밀번호 찾기"
          link="/mypage"
        />
        {/* 회원가입 하기 링크 */}
        <MemberQuestionBlock
          question="계정이 없으신가요?"
          linkText="회원가입 하기"
          link="/join"
          marginBottom="8rem"
        />
      </MemberForm>
    </MemberLayout>
  );
}

export default Login;
