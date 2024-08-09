package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import dao.ProductDAOClass;
import dao.exception.ProductException;
import dto.ProductRequest;
import dto.ProductResponse;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductDAOClass productDao;
	
	@InjectMocks
	private ProductService productService;
	
	@BeforeEach
	void setUp(){
		 productService = new ProductService() {
	            {
	                try {
	                    java.lang.reflect.Field field = ProductService.class.getDeclaredField("productDao");
	                    field.setAccessible(true);
	                    field.set(this, productDao);
	                } catch (Exception e) {
	                    fail("Failed to set mocked productDao");
	                }
	            }
	        };
		
		
	}
	
	@Test
	void testGetProductById() throws ProductException {
		
		//arrange
		ProductResponse mockResponse = new ProductResponse(1L, "Test Product", "TP", 100);
		Mockito.when(productDao.getProductById(mockResponse.getId())).thenReturn(mockResponse);
		
		//act
		ProductResponse response = productService.getProductById(mockResponse.getId());
		System.out.println(response.toString());
		
		//assert
		
		assertEquals(mockResponse,response);
		Mockito.verify(productDao, times(1)).getProductById(1L);
		
	}
	
	@Test
	void testCreateProduct() {
		ProductRequest productRequest = new ProductRequest("New Product", "NP", 100);
		when(productDao.createProduct(productRequest)).thenReturn(true);
		
		boolean result = productService.createProduct(productRequest);
		assertTrue(result);
		
		verify(productDao, times(1)).createProduct(productRequest);
		
	}
	
	

}
