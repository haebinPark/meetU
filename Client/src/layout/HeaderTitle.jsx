import { styled } from "styled-components";
import { Link } from "react-router-dom";
import logoImage from "../assets/siteLogo.png";

const SiteTitle = styled.h1`
  width: 10rem;
  height: 4rem;

  .header-title-link {
    background-color: pink;
    display: block;
    width: 100%;
    height: 100%;
    background: no-repeat center/100% url(${logoImage});
  }
`;

function HeaderTitle() {
  return (
    <SiteTitle>
      <Link to="/" aria-label="미츄" className="header-title-link"></Link>
    </SiteTitle>
  );
}

export default HeaderTitle;
