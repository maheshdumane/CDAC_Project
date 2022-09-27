import "slick-carousel/slick/slick.css";  
import "slick-carousel/slick/slick-theme.css";  
import Slider from "react-slick";
import { useHistory } from "react-router-dom";

function TopSlider(){
    const history=useHistory()
    const settings = {
        //dots: true,
        infinite: true,
        speed: 40000,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed:111,
        cssEase: "linear"
      };

function acslider(){
  history.push("./cats?cat=AC");
}
function soundslider(){
  history.push("cats?cat=Audio");
}
function tvslider(){
  history.push("./cats?cat=Televisions");
}

    return (
        <>
            <Slider {...settings}>   
              <div className="wdt">  
              <img  className="img" alt="pic1" src= {'assets/acslider.jpg'} onClick={acslider}/>  
              </div >  
              <div className="wdt">  
              <img  className="img" alt="pic1" src= {'assets/soundslider.jpg'} onClick={soundslider}/>  
              </div> 
              <div className="wdt">  
              <img  className="img" alt="pic1" src= {'assets/tvslider.jpg'} onClick={tvslider}/>  
              </div> 
            </Slider>
        </>        
    );
}

export default TopSlider;