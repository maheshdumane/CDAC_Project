package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.daos.CustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.Seller;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired 
	private CustomerDao dao;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public Customer registerCustomer(Customer cust) {
		cust.setPwd(this.passwordEncoder.encode(cust.getPwd()));
		return dao.save(cust);
	}

	@Override
	public List<Customer> allCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public Customer validate(String userid, String pwd) {
		Customer cc=dao.findByUserid(userid);
		if(cc!=null && passwordEncoder.matches(pwd, cc.getPwd() )) {
			return cc;
		}
		return null;
	}
	
	@Override
	public boolean verifyUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.findByUserid(userid)!=null;
	}

	@Override
	public void updateProfile(Customer cust) {
		// TODO Auto-generated method stub
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		cust.setPwd(this.passwordEncoder.encode(cust.getPwd()));
		dao.save(cust);	
	}
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer=dao.getById(id);
		dao.delete(customer);
	}

	@Override
	public void updateCustomerStatus(String status, int id) {
		// TODO Auto-generated method stub
		dao.updateCustomerStatus(status, id);
		
	}
	
}
