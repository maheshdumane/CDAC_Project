package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.daos.SellerDao;
import com.app.pojos.Seller;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired 
	private SellerDao dao;
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Override
	public Seller registerSeller(Seller seller) {
		seller.setPwd(this.passwordEncoder.encode(seller.getPwd()));
		return dao.save(seller);
	}

	@Override
	public List<Seller> allSellers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Seller findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public Seller validate(String userid, String pwd) {
		Seller seller=dao.findByUserid(userid);
		if(seller!=null && passwordEncoder.matches(pwd, seller.getPwd())) {
			return seller;
		}
		return null;
	}

	@Override
	public void deleteSeller(int id) {
		// TODO Auto-generated method stub
		Seller seller=dao.getById(id);
		dao.delete(seller);
	}

}
