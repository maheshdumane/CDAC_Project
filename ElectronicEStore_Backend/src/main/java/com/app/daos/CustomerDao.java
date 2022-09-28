package com.app.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	@Query(value = "select * from customer where email=? and status='active'", nativeQuery = true)
	Customer findByUserid(String userid);
	@Query(value = "select * from customer where status='active' order by id", nativeQuery = true)
	List<Customer>findAll();
	@Modifying
	@Transactional
	@Query(value = "update customer set status=? where id=?", nativeQuery = true)
	void updateCustomerStatus(String status,int id);
}
