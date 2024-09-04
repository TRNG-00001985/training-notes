package com.revature.revshop.dao;

import com.revature.revshop.dto.ProductRequest;
import com.revature.revshop.dto.ProductResponse;

public interface ProductDAO {
	
	boolean createProduct(ProductRequest productRequest);
	ProductResponse getProductById(long productId);

}
