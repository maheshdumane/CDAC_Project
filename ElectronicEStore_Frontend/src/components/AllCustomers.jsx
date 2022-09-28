import axios from "axios";
import { useEffect, useState } from "react";

function AllCustomers(){
    const [customers,setCustomers]=useState([])
    useEffect(()=>{
        axios.get("http://localhost:9090/api/customers")
        .then(resp=>{
            setCustomers(resp.data.data)
            console.log(customers)
        })
    },[])
    const deleteCustomer=(id)=>{
        let response=window.confirm('Are you sure to delete this Customer ?');
        if(response){
           console.log(id);
           axios.delete("http://localhost:9090/api/customers/"+id)
           .then(resp=>{
                axios.get("http://localhost:9090/api/customers")
                .then(resp=>{
                    //console.log(resp.data.data)
                    setCustomers(resp.data.data)            
                })
           })
        }
    }
    return (
        <div className="container-fluid">
            <h4 className="text-white p-2 text-center">All Customers</h4>
            <table className="table table-bordered table-dark table-striped table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>User Id</th>
                        <th>Action</th>
                        
                    </tr>
                </thead>
                <tbody>
                {customers.map(x=>(
                    <tr key={x.id}>
                        <td>{x.id}</td>
                        <td>{x.name}</td>
                        <td>{x.city}</td>
                        <td>{x.gender}</td>
                        <td>{x.phone}</td>
                        <td>{x.userid}</td>
                        <td><button onClick={(e)=>deleteCustomer(x.id)} className="btn btn-danger btn-sm">Delete</button></td>

                        
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default AllCustomers;