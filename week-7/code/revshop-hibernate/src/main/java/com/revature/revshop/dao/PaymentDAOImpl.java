package com.revature.revshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.revshop.model.CreditCardPayment;
import com.revature.revshop.model.GooglePayPayment;
import com.revature.revshop.model.Payment;


@Repository
public class PaymentDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void getPaymentInfo() {
		
		CreditCardPayment creditCard = new CreditCardPayment(1,-10.00, "INR", "4569-0909-0909-4040", "Visa");
		GooglePayPayment googlePayPayment = new GooglePayPayment(2,2000.00, "INR", "krishna@okicici");
			
		Session session = sessionFactory.openSession();

		session.save(googlePayPayment);
		session.save(creditCard);
		
		Transaction tx = session.beginTransaction();
		
		
	
		
		System.out.println(session.createQuery("from Payment").getResultList());
		tx.commit();

		
	}


}
