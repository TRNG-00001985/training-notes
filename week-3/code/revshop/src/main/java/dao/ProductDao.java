package dao;

import java.util.List;
import java.util.Optional;

import dto.ProductRequest;
import dto.ProductResponse;
import entity.Product;

public interface ProductDao {
	
	Optional<ProductResponse> getProductById(long id) throws Exception;
	boolean createProduct(ProductRequest productRequest);
	boolean updateProduct(ProductRequest productRequest, long productId);
	boolean deleteProduct(long id);
	List<Optional<ProductResponse>> getAllProducts();

}
