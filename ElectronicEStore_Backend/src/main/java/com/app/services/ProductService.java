package com.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Product;

public interface ProductService {
	void addProduct(Product p,MultipartFile pic);
	List<Product> findProducts(int sellerId);
	void updateProduct(Product p);
	void deleteProduct(int prodid);
	List<Product> allProducts();
	List<Product> categoryProducts(String pcat);
	Product findProductById(int prodid);
	Page<Product> allProductsPaginated(int page,int pagesize);
	void deleteBySellerId(int id);
	void updateStatus(String status,int id);
	void updateStatusBySeller(String status,int id);
}
