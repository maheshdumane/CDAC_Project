package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.OrderDefailsDao;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

@Service
public class OrderDetailsServiceImpl implements OrderdetailService {

	@Autowired OrderDefailsDao dao;
	@Override
	public void saveOrderDetails(OrderDetails od) {
		// TODO Auto-generated method stub
		dao.save(od);
	}

	@Override
	public OrderDetails findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<OrderDetails> findByOrder(Order order) {
		// TODO Auto-generated method stub
		return dao.findByOrder(order);
	}

	@Override
	public void deleteByCustomerId(int id) {
		// TODO Auto-generated method stub
		dao.deleteByCustomerId(id);
	}

}
