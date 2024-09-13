package com.revature.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.revshop.dto.OrderRequest;
import com.revature.revshop.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		
		try {
			
			orderService.placeOrder(orderRequest);
		return new ResponseEntity<>("order placed successfully", HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new HttpClientErrorException(HttpStatusCode.valueOf(500));
		}
	}

}
