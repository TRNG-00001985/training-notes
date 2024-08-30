package com.revature.revshop.dao;

import com.revature.revshop.dto.OrderRequest;
import com.revature.revshop.dto.OrderResponse;

public interface OrderDAO {
	
	boolean createOrder(OrderRequest orderRequest);
	OrderResponse getOrderById(Long orderId);
	

}
