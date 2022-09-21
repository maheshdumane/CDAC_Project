import { useSelector } from "react-redux";

function Header(){
    const state=useSelector((state)=>state);
    console.log("Header ",state.loggedin.Username)
    return (
        <div className="jumbotron p-3 mb-0 rounded-0 bg-white text-dark" style={{opacity: 1}}>
            <img src={'images.jfif'} style={{height:"50px",width:"100px"}} className="float-left"/>
            {state.loggedin.IsLoggedIn ?
            <>            
            {/* <h5 className="float-left">Role : {state.loggedin.Role}</h5> */}
            <h5 className="float-right">Welcome ! {state.loggedin.Username}</h5> </>:
            ''}
            <h2 className="text-center">Welcome to Electronics Store</h2>
            <div className="clearfix"></div>
        </div>
    )
}

export default Header;