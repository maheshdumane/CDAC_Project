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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.LoginDTO;
import com.app.dto.Response;
import com.app.pojos.EmailDetails;
import com.app.pojos.Seller;
import com.app.services.EmailService;
import com.app.services.ProductService;
import com.app.services.SellerService;

@CrossOrigin
@RestController
@RequestMapping("/api/sellers")
public class SellerController {

	@Autowired 
	private SellerService sellerService;
	@Autowired 
	private ProductService productService;
	@Autowired
	private EmailService emailService;
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Seller seller) {		
		
		try {	
			String details="Congratulations your Registration is successful.";
			EmailDetails email=new EmailDetails(seller.getUserid(), details, "Electronic E Store registration");
			emailService.sendSimpleMail(email);
			return new ResponseEntity<>(sellerService.registerSeller(seller), HttpStatus.CREATED);

		}catch (RuntimeException e) {
			System.out.println("err in add " + e);
			return new ResponseEntity<>(new ErrorResponse("Adding Seller failed!!!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		sellerService.registerSeller(seller);
//		return Response.success(seller);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCustomers() {
		List<Seller> result = sellerService.allSellers();
		return Response.success(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findSellerProfile(@PathVariable("id") int id) {
		Seller result = sellerService.findById(id);
		return Response.success(result);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSeller(@PathVariable("id") int id) {
		//productService.deleteBySellerId(id);
		//sellerService.deleteSeller(id);
		sellerService.updateSellerStatus("deleted", id);
		productService.updateStatusBySeller("deleted", id);
		return Response.status(HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Seller user=sellerService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
}
