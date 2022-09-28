package com.app.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {
	
	@Query(value = "select * from sellers where status='active' order by id", nativeQuery = true)
	List<Seller>findAll();
	
	@Query(value = "select * from sellers where email=? and status='active'", nativeQuery = true)
	Seller findByUserid(String userid);
	@Modifying
	@Transactional
	@Query(value = "update sellers set status=? where id=?", nativeQuery = true)
	void updateSellerStatus(String status,int id);

}
