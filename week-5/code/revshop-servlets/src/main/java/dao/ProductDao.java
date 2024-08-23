package dao;

import java.util.List;
import java.util.Optional;

import controller.ProductController;
import dao.exception.ProductException;
import dto.ProductRequest;
import dto.ProductResponse;
import entity.Product;

public interface ProductDao {
	
	
	ProductResponse getProductById(long id) throws ProductException;
	boolean createProduct(ProductRequest productRequest);
	boolean updateProduct(ProductResponse productResponse);
	boolean deleteProduct(long id);
	List<ProductResponse> getAllProducts();

}
