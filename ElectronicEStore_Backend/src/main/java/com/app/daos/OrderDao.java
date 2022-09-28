package com.app.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
	List<Order> findByCustomer(Customer customer);
	@Modifying
	@Transactional
	@Query(value="delete from orders where customerId=?", nativeQuery = true)
	void deleteByCustomerId(int id);
}
