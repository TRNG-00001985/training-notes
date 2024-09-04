package com.revature.revshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.revshop.dto.ProductRequest;
import com.revature.revshop.dto.ProductResponse;
import com.revature.revshop.model.Product;
import com.revature.revshop.model.User;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createProduct(ProductRequest productRequest) {
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			User user = session.get(User.class, productRequest.getUserId());
			
			if(user!=null) {
			
			Product product = Product.builder()
					.name(productRequest.getName())
					.description(productRequest.getDescription())
					.price(productRequest.getPrice())
					.user(user)
					.build();
			
			
			session.save(product);
			
			tx.commit();
			
			return true;
			}
			else {
				throw new Exception("user doesnt exist");
			}
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		session.close();
		
		return false;
	}

	@Override
	public ProductResponse getProductById(long productId) {
Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			Product product = session.get(Product.class, productId);
			
			ProductResponse productResonse = ProductResponse.builder()
					.name(product.getName())
					.description(product.getDescription())
					.price(product.getPrice())
					.userId(product.getUser().getId())
					.build();
						
			tx.commit();
			
			return productResonse;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		session.close();
		return null;
	}

}
