package com.revature.revshop.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.revshop.dto.ProductRequest;
import com.revature.revshop.dto.ProductResponse;
import com.revature.revshop.model.Product;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.ProductRepository;
import com.revature.revshop.repository.UserRepository;


@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	private UserRepository userRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	public ProductResponse getProductById(Long id) {
		// TODO Auto-generated method stub
		Product p =  productRepository.findById(id).get();
		
		return ProductResponse.builder()
				.id(p.getId())
				.name(p.getName())
				.description(p.getDescription())
				.price(p.getPrice())
				.userId(p.getId())
				.build();
		
		
	}

	public ProductResponse createProduct(ProductRequest productRequest) {
		
		User user = userRepository.findById(productRequest.getUserId()).get();
		
		Product p = Product.builder()
				.user(user)
				.name(productRequest.getName())
				.price(productRequest.getPrice())
				.description(productRequest.getDescription())
				.build();
		
		p = productRepository.save(p);
		
		return ProductResponse.builder()
				.id(p.getId())
				.name(p.getName())
				.description(p.getDescription())
				.price(p.getPrice())
				.userId(p.getId())
				.build();
		
	}
	

}
