import { styled } from "styled-components";
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
  position: relative;
  width: 22%;
`;

const CheckboxLabel = styled.label`
  display: inline-block;
  width: 100%;
  height: 30px;
  border: 2px solid var(--brand-color);
  border-radius: 8px;
  background-color: ${(p) => (p.$isChecked ? "var(--brand-color)" : "white ")};
  color: ${(p) => (p.$isChecked ? "white " : "var(--brand-color)")};
  font-size: 90%;
  font-weight: 500;
  line-height: 190%;
  text-align: center;

  &:hover {
    color: white;
    background-color: var(--brand-color);
  }
`;

const CheckboxInput = styled.input`
  position: absolute;
  top: 20%;
  left: 40%;
  opacity: 0;
`;

const interests = [
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

function MemberFormCheckbox({ checkedList, onChange }) {
  return (
    <Fieldset>
      <Legend>관심사</Legend>
      <InputDescription>관심사를 1 ~ 3개 선택해주세요.</InputDescription>
      <Ul>
        {interests.map((item) => {
          return (
            <Li key={item.id}>
              <CheckboxLabel
                htmlFor={item.type}
                $isChecked={checkedList?.includes(item.type)}
              >
                {item.type}
                <CheckboxInput
                  type="checkbox"
                  id={item.type}
                  name="interests"
                  value={item.type}
                  onChange={onChange}
                />
              </CheckboxLabel>
            </Li>
          );
        })}
      </Ul>
    </Fieldset>
  );
}

export default MemberFormCheckbox;
