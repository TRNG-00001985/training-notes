package com.revature.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revshop.service.PaymentService;

@RestController
@RequestMapping("/payment/")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	
	public void getPaymentInfo() {
		paymentService.getPaymentInfo();
	}

}
