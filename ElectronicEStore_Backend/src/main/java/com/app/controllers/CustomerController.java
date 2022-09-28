package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.LoginDTO;
import com.app.dto.Response;
import com.app.pojos.Customer;
import com.app.pojos.EmailDetails;
import com.app.services.CustomerService;
import com.app.services.EmailService;
import com.app.services.OrderService;
import com.app.services.OrderdetailService;

import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired 
	CustomerService customerService;
	@Autowired 
	OrderService orderService;
	@Autowired 
	OrderdetailService orderDetailService;
	@Autowired private EmailService emailService;
	
	@PostMapping
	@ApiOperation(value="Save a customer details",response = Customer.class)
	
	public ResponseEntity<?> save(@Valid @RequestBody Customer cust) {
		try {
			
			String details="Congratulations your Registration is successful.";
			EmailDetails email=new EmailDetails(cust.getUserid(), details, "Electronic E Store registration");
			emailService.sendSimpleMail(email);
			return new ResponseEntity<>(customerService.registerCustomer(cust), HttpStatus.CREATED);
//			customerService.registerCustomer(cust);
//			return Response.success(cust);
			
		}catch (RuntimeException e) {
			System.out.println("err in add " + e);
			return new ResponseEntity<>(new ErrorResponse("Adding Customer failed!!!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping
	@ApiOperation(value="List all customers",response=Iterable.class)
	public ResponseEntity<?> findAllCustomers() {
		List<Customer> result = customerService.allCustomers();
		return Response.success(result);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Display the details of a customer")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") int id) {
		Customer result = customerService.findById(id);
		return Response.success(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Customer user=customerService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Customer cust,@PathVariable("id") int id) {
		customerService.updateProfile(cust);
		return Response.status(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
		orderDetailService.deleteByCustomerId(id);
		orderService.deleteByCustomerId(id);
		customerService.deleteCustomer(id);
		return Response.status(HttpStatus.OK);
	}

}
