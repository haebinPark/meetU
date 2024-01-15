import { styled } from "styled-components";

const StyleCodeUl = styled.ul`
  display: flex;
  justify-content: center;
  gap: 3%;
  width: 100%;
  position: absolute;
  bottom: -160%;
  right: 0%;
  border: 1px solid var(--font-lightgray);
  border-radius: 8px;
  box-shadow:
    0 10px 15px -3px rgb(0 0 0 / 0.1),
    0 4px 6px -4px rgb(0 0 0 / 0.1);
`;

const StyleCodeLi = styled.li`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0.5rem 0;
`;

const StyleCodeInput = styled.input`
  appearance: none;
  width: 1.5rem;
  height: 1.5rem;
  border-radius: 50%;
  border: 1px solid var(--font-lightgray);
  background-color: white;
  position: relative;
  transition: all 0.2s ease-in-out;

  &::after {
    display: block;
    content: "";
    width: 1.1rem;
    height: 1.1rem;
    border-radius: 50%;
    border: 1px solid var(--font-lightgray);
    background-color: ${({ value }) => value};
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    transition: all 0.2s ease-in-out;
  }

  &:hover,
  &:focus {
    cursor: pointer;
  }

  &:hover,
  &:checked {
    outline: none;
    border-width: 3px;
  }

  &:hover::after,
  &:checked::after {
    border-width: 3px;
    width: 0.9rem;
    height: 0.9rem;
  }
`;

const StyleCodeLabel = styled.label`
  color: var(--font-gray);
  font-weight: 300;
  font-size: 0.8rem;
`;

const styleCode = {
  brown: "#f4eeee",
  orange: "#faebdd",
  yellow: "#fbf3db",
  green: "#edf3ec",
  blue: "#e7f3f8",
  purple: "#f6f3f9",
  pink: "#faf1f5",
  red: "#fdebec",
};

const translateColor = (en) => {
  switch (en) {
    case "brown":
      return "갈색";
    case "orange":
      return "주황";
    case "yellow":
      return "노랑";
    case "green":
      return "초록";
    case "blue":
      return "파랑";
    case "purple":
      return "보라";
    case "pink":
      return "분홍";
    case "red":
      return "빨강";
  }
};

const styleCodeList = Object.entries(styleCode);

function StyleCodePalette({ styleCode, handleStyleCode }) {
  return (
    <StyleCodeUl>
      {styleCodeList.map((item) => {
        return (
          <StyleCodeLi key={item[0]}>
            <StyleCodeInput
              type="radio"
              id={item[0]}
              name={item[0]}
              value={item[1]}
              checked={styleCode === item[1]}
              onChange={handleStyleCode}
            />
            <StyleCodeLabel htmlFor={item[0]}>
              {translateColor(item[0])}
            </StyleCodeLabel>
          </StyleCodeLi>
        );
      })}
    </StyleCodeUl>
  );
}

export default StyleCodePalette;
