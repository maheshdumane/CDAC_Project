package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.daos.ProductDao;
import com.app.pojos.Product;
import com.app.utils.StorageService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired ProductDao dao;
	@Autowired
	private StorageService storageService;
	@Autowired SellerService sellerService;
	@Override
	public void addProduct(Product p,MultipartFile pic) {
		// TODO Auto-generated method stub
		String photo=storageService.store(pic);
		p.setPhoto(photo);
		dao.save(p);
	}

	@Override
	public List<Product> findProducts(int sellerId) {
		// TODO Auto-generated method stub
		//return dao.findBySeller(sellerService.findById(sellerId),Sort.by(Sort.Direction.DESC,"prodid"));
		return dao.findBySellerId(sellerId);
	}

	@Override
	public void updateProduct(Product p) {
		Product pp=dao.getById(p.getProdid());
		p.setSeller(pp.getSeller());
		dao.save(p);
	}

	@Override
	public void deleteProduct(int prodid) {
		// TODO Auto-generated method stub
		Product p=dao.getById(prodid);
		dao.delete(p);
	}

	@Override
	public List<Product> allProducts() {
		
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.DESC,"prodid"));
		//return dao.findAllProduct();
	}

	@Override
	public Product findProductById(int prodid) {
		// TODO Auto-generated method stub
		return dao.getById(prodid);
	}

	@Override
	public List<Product> categoryProducts(String pcat) {
		// TODO Auto-generated method stub
		//return dao.findByPcat(pcat,Sort.by(Sort.Direction.DESC,"prodid"));
		return dao.findByCategory(pcat);
	}

	@Override
	public Page<Product> allProductsPaginated(int page,int pagesize) {
		
		Page<Product> prods=dao.findAll(PageRequest.of(page, pagesize));
		
		return prods;
	}

	@Override
	public void deleteBySellerId(int id) {
		// TODO Auto-generated method stub
		dao.deleteBySeller(id);
		
	}

	@Override
	public void updateStatus(String status, int id) {
		// TODO Auto-generated method stub
		dao.updateStatus(status, id);
		
	}

	@Override
	public void updateStatusBySeller(String status, int id) {
		// TODO Auto-generated method stub
		dao.updateStatusBySeller(status, id);
		
	}
}
