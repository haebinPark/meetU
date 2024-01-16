import { styled } from "styled-components";

const SendNoteButton = styled.button`
  position: absolute;
  right: ${({ $positionTop }) => $positionTop || "-60%"};
  bottom: ${({ $positionBottom }) => $positionBottom || "-30%"};
  display: block;
  z-index: 1;
  background-color: white;
  border: 1px solid var(--font-gray);
  padding: 4px;
  border-radius: 5px;
  cursor: pointer;

  &:hover {
    color: var(--brand-color);
    text-decoration: underline;
  }
`;

export default SendNoteButton;
