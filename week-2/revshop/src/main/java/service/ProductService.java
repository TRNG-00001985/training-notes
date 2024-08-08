package service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dao.ProductDAOClass;
import dao.exception.ProductException;
import dto.ProductRequest;
import dto.ProductResponse;
import entity.Product;

public class ProductService {
	
	private final ProductDAOClass productDao;
	
	public ProductService() {
		
		productDao = new ProductDAOClass();
	}
	
	public ProductResponse getProductById(long id) throws ProductException {
		
				try {
					return productDao.getProductById(id).get();
					
				}
				catch(Exception e) {
					
					throw new ProductException(null);
					
				}
	}
	
	public boolean createProduct(ProductRequest productRequest) {
		return productDao.createProduct(productRequest);
	}
	
	public List<ProductResponse> getAllProducts(){
		List<ProductResponse> products = productDao.getAllProducts().stream()
				.map(product -> product.get())
				.collect(Collectors.toList());
		
		return products;
	}
	
	public static void main(String[] args) throws Exception {
		ProductService p = new ProductService();
//		
//		System.out.println(p.createProduct(new ProductRequest("Demo product", "DM", 8949.7F)));
//		
		System.out.println(p.getProductById(100).toString());
		
		List<ProductResponse> products = p.getAllProducts();
//		
//		for(ProductResponse product: products) {
//			System.out.println(product.toString());
//		}
		
		// filter
		List<ProductResponse> filteredProductsByPrice = products.stream()
				.filter(product -> product.getPrice() > 500)
				.collect(Collectors.toList());
		
		for(ProductResponse product: filteredProductsByPrice) {
			System.out.println(product.toString());
		}
		
		//map
		
		List<String> productNames = products.stream()
				.map(ProductResponse::getName)
				.collect(Collectors.toList());
		
		for(String product: productNames) {
			System.out.println(product);
		}
		
		//sort
		List<ProductResponse> sortedProducts = products.stream()
				.sorted(Comparator.comparingDouble(ProductResponse::getPrice))
				.collect(Collectors.toList());
		
		List<String> sortedProductNames = productNames.stream()
				.sorted()
				.collect(Collectors.toList());
		
		for(String product: sortedProductNames) {
			System.out.println(product);
		}
		
		
		
		
	}
	

}
