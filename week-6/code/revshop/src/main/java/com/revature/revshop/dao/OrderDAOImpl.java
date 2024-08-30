package com.revature.revshop.dao;

import org.springframework.stereotype.Repository;

import com.revature.revshop.dto.OrderRequest;
import com.revature.revshop.dto.OrderResponse;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Override
	public boolean createOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderResponse getOrderById(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
