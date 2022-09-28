package com.app.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;
import com.app.pojos.Seller;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	@Modifying
	@Query(value = "select * from product where sellerId=? and status='available' group by pname order by prodid", nativeQuery = true)
	List<Product> findBySellerId(int sellerId);
	
	List<Product> findBySeller(Seller sellerId,Sort sort);
	@Modifying
	@Query(value = "select * from product where pcat=? and status='available' group by pname order by prodid", nativeQuery = true)
	List<Product> findByCategory(String pcat);
	List<Product> findByPcat(String pcat,Sort sort);
	@Modifying
	@Transactional
	@Query(value = "delete from product where sellerId=?", nativeQuery = true)
	void deleteBySeller(int id);
	
	
	@Query(value = "select * from product where status='available' group by pname", nativeQuery = true)
	Page<Product> findAll(Pageable pageable);
	@Modifying
	@Transactional
	@Query(value = "update product set status=? where prodid=?", nativeQuery = true)
	void updateStatus(String status,int id);
	
	
}
