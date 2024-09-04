package com.revature.revshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.revshop.dao.PaymentDAOImpl;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDAOImpl paymentDao;
	
	
	public void getPaymentInfo() {
		
		 paymentDao.getPaymentInfo();
		
	}

}
