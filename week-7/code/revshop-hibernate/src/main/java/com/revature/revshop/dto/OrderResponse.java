package com.revature.revshop.dto;

import java.util.List;

public class OrderResponse {
	private Long id;
	private Long userId;
    private Double totalPrice;
    private String address;
    private String payment;
    private List<Long> productIds;

}
