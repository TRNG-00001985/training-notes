package com.revature.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revshop.dto.ProductRequest;
import com.revature.revshop.dto.ProductResponse;
import com.revature.revshop.service.ProductService;


@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	ProductService productService;
//	
//	
	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
		
		try {
			return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return null;
		}
		
	}
	@GetMapping()
	public ResponseEntity<ProductResponse> getProductById(@RequestParam Long id) {
		return  ResponseEntity.ok(productService.getProductById(id));
		
	}
//	
//	@PutMapping
//	public boolean updateProductById(@RequestBody ProductRequest productRequest) {
//		
//		try {
//			return productService.createProduct(productRequest);
//		}
//		catch(Exception e) {
//			return false;
//		}
//		
//	}
//	
//	
//	
//	

}
