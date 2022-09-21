import "slick-carousel/slick/slick.css";  
import "slick-carousel/slick/slick-theme.css";  
import Slider from "react-slick";

function TopSlider(){
    const settings = {
        //dots: true,
        infinite: true,
        speed: 30000,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed:111,
        cssEase: "linear"
      };

    return (
        <>
            <Slider {...settings}>   
              <div className="wdt">  
              <img  className="img" alt="pic1" src= {'assets/iphone.jfif'}/>  
              </div >  
              <div className="wdt">  
              <img  className="img" alt="pic1" src= {'assets/sony1.jpg'}/>  
              </div> 
              <div className="wdt">  
              <img  className="img" alt="pic1" src= {'assets/hp.jpg'}/>  
              </div> 
            </Slider>
        </>        
    );
}

export default TopSlider;