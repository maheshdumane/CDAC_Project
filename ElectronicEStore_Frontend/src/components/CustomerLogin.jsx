import axios from "axios";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { useHistory } from "react-router-dom";
import loginvalidation from "../loginvalidation"

function CustomerLogin(){
    const  validcaptcha=false;

    const dispatch=useDispatch()

    const [user,setUser]=useState({
        "userid":"",
        "pwd":""
    })
    const [captcha,setCaptcha]=useState({
        "capt":"",
        "textinput":""
    })

    const [errors,setErrors]=useState({})
    const [submitted,setSubmitted]=useState(false)
    const history=useHistory()

    const handleInput=(e)=>{
        setUser({...user,[e.target.name]:e.target.value})
        setCaptcha({...captcha,[e.target.name]:e.target.value})
    }

    const handleSubmit=e=>{
        validcap();
        e.preventDefault()
        setErrors(loginvalidation(user))   
        setSubmitted(true) 
    }
    
    function validcap(){
                    var stg1 = captcha.capt;
                    var stg2 = captcha.textinput;
                    if(stg1==stg2){
                      validcaptcha=true;
                      return true;
                    }else{
                      alert("Please enter a valid captcha");
                      validcaptcha=false;
                      return false;
                    }
                   }

    function cap(){
        
        var alpha = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'
        ,'W','X','Y','Z','1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h','i',
        'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
        var a = alpha[Math.floor(Math.random()*62)];
        var b = alpha[Math.floor(Math.random()*62)];
        var c = alpha[Math.floor(Math.random()*62)];
        var d = alpha[Math.floor(Math.random()*62)];
        var e = alpha[Math.floor(Math.random()*62)];
        var f = alpha[Math.floor(Math.random()*62)];

        var final = a+b+c+d+e+f;
        console.log("this is captcha string in use effect "+final);
        captcha.capt=final; 
    }

    useEffect(()=>{
        cap();
    },[""])

    useEffect(()=>{
        console.log(errors)
        if(Object.keys(errors).length===0 && submitted && validcaptcha){
            console.log(user)
            axios.post("http://localhost:9090/api/customers/validate",user)
            .then(resp=>{
                let result=resp.data.data;
                console.log(resp.data.data)
                sessionStorage.setItem("userid",result.userid)
                sessionStorage.setItem("uname",result.name)
                sessionStorage.setItem("role","customer")
                sessionStorage.setItem("id",result.id)  
                dispatch({type:'IsLoggedIn'})
                history.push("/")
            })
            .catch(error=>{
                console.log("Error",error);
                alert("Invalid username or password")
            })            
        }
    },[errors])


    return (
        
    <div className="container">
        <script>
            
        </script>
    <div className="card shadow bg-dark mt-3 text-white">
        <div className="card-body">            
            <div className="row">
                <div className="col-sm-6 mx-auto">
                    <h4 className="text-center p-2">
                        Customer Login Form
                    </h4>
                    <form onSubmit={handleSubmit} onLoad={cap}>                 
                    <div className="form-group form-row">
                        <label className="col-sm-4 form-control-label">Email Id</label>
                        <div className="col-sm-8">
                            <input type="text" name="userid" value={user.userid} onChange={handleInput} className="form-control" />
                            {errors.userid && <small className="text-danger float-right">{errors.userid}</small>}
                        </div>
                        
                    </div>                    
                    <div className="form-group form-row">
                        <label className="col-sm-4 form-control-label">Password</label>
                        <div className="col-sm-8">
                            <input type="password" name="pwd" value={user.pwd} onChange={handleInput} className="form-control" />
                            {errors.pwd && <small className="text-danger float-right">{errors.pwd}</small>}
                        </div>
                    </div> 
                    <label>Enter Captcha:</label>
                    <div className="form-row">
                        <div className="form-group col-md-6">
                        <input type="text" className="form-control" id="captcha"  name="capt" value={captcha.capt} readOnly></input>
                        </div>
                        <div className="form-group col-md-6">
                        <input type="text" className="form-control" name="textinput" onChange={handleInput}></input>
                        </div>
                    </div>              
                    <button className="btn btn-primary float-right">Login Now</button>
                    </form>
                </div>
            </div>
        </div>
        
        </div>
    </div>
    );
}

export default CustomerLogin;