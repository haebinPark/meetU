import { styled } from "styled-components";

const MemberFormButtonBlock = styled.div`
  text-align: center;
  margin-bottom: ${({ $marginBottom }) => $marginBottom};
  margin-left: auto;
  margin-right: auto;
  display: flex;
  justify-content: center;
  gap: 10px;
`;

export default MemberFormButtonBlock;
