package com.app.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

@Repository
public interface OrderDefailsDao extends JpaRepository<OrderDetails, Integer> {
	List<OrderDetails> findByOrder(Order order);
	@Modifying
	@Transactional
	@Query(value="delete from orderdetails where customerId=?", nativeQuery = true)
	void deleteByCustomerId(int id);
}
