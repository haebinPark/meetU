import { styled, css } from "styled-components";

//크기 CSS
const SIZES = {
  sm: css`
    --button-font-size: 1rem;
    --button-padding: 0.3125rem 1rem;
  `,
  md: css`
    --button-padding: 0.8125rem 3.4375rem;
    --button-font-size: 1.25rem;
  `,
  lg: css`
    --button-font-size: 1.5625rem;
    --button-padding: 0.9375rem 5rem;
  `,
};

//변형 CSS
const VARIANTS = {
  greybtn: css`
    --button-bg-color: #888888;
    --button-hover-bg-color: #d9d9d9;
  `,
  subbtn: css`
    --button-bg-color: #9bbd8a;
    --button-hover-bg-color: #4f8235;
  `,
};

//메인 CSS
const StyledButton = styled.button`
  ${(p) => p.sizeStyle}
  ${(p) => p.variantStyle}

  margin: 0;
  border: none;
  cursor: pointer;
  font-family: "IBM Plex Sans KR", sans-serif;
  font-size: var(--button-font-size, 1rem);
  padding: var(--button-padding, 0.75rem 1rem);
  border-radius: var(--button-radius, 0.625rem);
  color: var(--button-color, #ffffff);
  background: var(--button-bg-color, var(--brand-color));

  &:active,
  &:hover,
  &:focus {
    background: var(--button-hover-bg-color, var(--brand-sub-color));
  }
`;

//버튼 함수부분
function Button({ onClick, size, variant, children }) {
  const sizeStyle = SIZES[size];
  const variantStyle = VARIANTS[variant];

  return (
    <StyledButton
      onClick={onClick}
      sizeStyle={sizeStyle}
      variantStyle={variantStyle}
    >
      {children}
    </StyledButton>
  );
}

export default Button;
