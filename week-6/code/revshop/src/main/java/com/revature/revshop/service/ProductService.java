package com.revature.revshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.revshop.dao.ProductDAOImpl;
import com.revature.revshop.dto.ProductRequest;
import com.revature.revshop.dto.ProductResponse;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAOImpl productDAO;
	
	
	public boolean createProduct(ProductRequest productRequest) {
		
		return productDAO.createProduct(productRequest);
		
	}
	
	public ProductResponse getProductById(long id) {
		
		return productDAO.getProductById(id);
		
	}

}
