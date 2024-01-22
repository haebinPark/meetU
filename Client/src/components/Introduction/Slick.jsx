import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { styled } from "styled-components";
import SlickPage1 from "../../assets/slickpage1.gif";
import SlickPage2 from "../../assets/slickpage2.gif";
import SlickPage3 from "../../assets/slickpage3.gif";
import SlickPage4 from "../../assets/slickpage4.gif";

const Image = styled.img`
  width: 100%;
`;

export default function Slick() {
  const settings = {
    dots: false,
    infinite: true,
    autoplay: true,
    autoplaySpeed: 5000,
    speed: 3000,
    slidesToShow: 1,
    slidesToScroll: 1,
    nextArrow: <NextArrow />,
    prevArrow: <PrevArrow />,
  };

  return (
    <div>
      <Slider {...settings}>
        <div>
          <Image src={SlickPage1}></Image>
        </div>
        <div>
          <Image src={SlickPage2}></Image>
        </div>
        <div>
          <Image src={SlickPage3}></Image>
        </div>
        <div>
          <Image src={SlickPage4}></Image>
        </div>
      </Slider>
    </div>
  );
}

const NextArrow = ({ onClick }) => {
  return (
    <button onClick={onClick} type="button">
      w
    </button>
  );
};

const PrevArrow = ({ onClick }) => {
  return (
    <button onClick={onClick} type="button">
      n
    </button>
  );
};
