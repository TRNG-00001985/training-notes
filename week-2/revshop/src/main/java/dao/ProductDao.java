package dao;

import java.util.List;

import dto.ProductRequest;
import dto.ProductResponse;
import entity.Product;

public interface ProductDao {
	
	ProductResponse getProductById(long id);
	boolean createProduct(ProductRequest productRequest);
	boolean updateProduct(ProductResponse productResponse);
	boolean deleteProduct(long id);
	List<ProductResponse> getAllProducts();

}
