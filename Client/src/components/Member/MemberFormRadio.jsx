import { styled } from "styled-components";
import { useState } from "react";
import InputDescription from "./InputDescription.jsx";

const Fieldset = styled.fieldset`
  border: none;
`;

const Legend = styled.legend`
  color: var(--brand-color);
  font-size: 1.1rem;
  font-weight: 500;
  display: inline-block;
`;

const Ul = styled.ul`
  max-width: 22.5rem;
  margin-top: 10px;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 10px;
`;

const Li = styled.li`
  border: 2px solid var(--brand-color);
  border-radius: 8px;
  color: var(--brand-color);
  font-size: 90%;
  font-weight: 500;
  position: relative;
  width: 22%;
  height: 30px;
  text-align: center;

  &:focus-within,
  &:hover {
    color: white;
    background-color: var(--brand-color);
  }
`;

const RadioLabel = styled.label`
  line-height: 180%;
`;

const RadioInput = styled.input`
  position: absolute;
  top: 20%;
  left: 40%;
  opacity: 0;
`;

const mbti = [
  { id: 1, type: "ISTJ" },
  { id: 2, type: "ISFJ" },
  { id: 3, type: "INFJ" },
  { id: 4, type: "INTJ" },
  { id: 5, type: "ISTP" },
  { id: 6, type: "ISFP" },
  { id: 7, type: "INFP" },
  { id: 8, type: "INTP" },
  { id: 9, type: "ESTP" },
  { id: 10, type: "ESFP" },
  { id: 11, type: "ENFP" },
  { id: 12, type: "ENTP" },
  { id: 13, type: "ESTJ" },
  { id: 14, type: "ESFJ" },
  { id: 15, type: "ENFJ" },
  { id: 16, type: "ENTJ" },
];

const interest = [
  { id: 1, type: "음악" },
  { id: 2, type: "영화" },
  { id: 3, type: "운동" },
  { id: 4, type: "여행" },
  { id: 5, type: "게임" },
  { id: 6, type: "음식" },
  { id: 7, type: "봉사활동" },
  { id: 8, type: "미술" },
  { id: 9, type: "독서" },
  { id: 10, type: "패션" },
  { id: 11, type: "코딩" },
  { id: 12, type: "요리" },
  { id: 13, type: "댄스" },
  { id: 14, type: "사진" },
  { id: 15, type: "영상" },
  { id: 16, type: "공부" },
];

function MemberFormRadio({ groupType }) {
  const [seletedMbti, setSelecteMbti] = useState("");
  const [selectedInterest, setSelectedInterest] = useState("");

  const group = groupType === "mbti" ? mbti : interest;
  const description =
    groupType === "mbti"
      ? "MBTI를 선택해주세요."
      : "관심사를 1 ~ 3개 선택해주세요.";

  const handleMbti = (e) => setSelecteMbti(e.target.value);
  const handleInterest = (e) => console.dir(e.target);

  return (
    <Fieldset>
      <Legend>MBTI</Legend>
      <InputDescription>{description}</InputDescription>
      <Ul>
        {group.map((item) => {
          return (
            <Li
              key={item.id}
              onChange={item.type === "mbti" ? handleMbti : handleInterest}
            >
              <RadioLabel htmlFor={item.type}>{item.type}</RadioLabel>
              <RadioInput
                type="radio"
                id={item.type}
                name={groupType}
                value={item.type}
              />
            </Li>
          );
        })}
      </Ul>
    </Fieldset>
  );
}

export default MemberFormRadio;
