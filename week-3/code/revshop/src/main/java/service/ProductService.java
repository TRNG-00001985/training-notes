package service;

import java.util.List;

import dao.ProductDAOClass;
import dto.ProductRequest;
import dto.ProductResponse;

public class ProductService {
	
	private final ProductDAOClass productDao;
	
	public ProductService() {
		
		productDao = new ProductDAOClass();
	}
	
	public ProductResponse getProductById(long id) {
		
		return productDao.getProductById(id);
	}
	
	public boolean createProduct(ProductRequest productRequest) {
		return productDao.createProduct(productRequest);
	}
	
	public List<ProductResponse> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public static void main(String[] args) {
		ProductService p = new ProductService();
//		
//		System.out.println(p.createProduct(new ProductRequest("Demo product", "DM", 8949.7F)));
//		
		System.out.println(p.getProductById(2).toString());
		
		List<ProductResponse> products = p.getAllProducts();
		
		for(ProductResponse product: products) {
			System.out.println(product.toString());
		}
	}
	

}
