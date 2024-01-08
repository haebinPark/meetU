import { styled } from "styled-components";

const Title = styled.h2`
  color: var(--brand-color);
  font-size: 2rem;
  font-weight: 500;
  text-align: center;
  margin-bottom: 1rem;
`;

function PageTitle({ pageTitle }) {
  return <Title>{pageTitle}</Title>;
}

export default PageTitle;
