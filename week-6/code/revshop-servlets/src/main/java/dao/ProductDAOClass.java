package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import dao.exception.ProductException;
import dto.ProductRequest;
import dto.ProductResponse;
import utils.ConnectionFactory;

public class ProductDAOClass implements ProductDao{	
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOClass.class);

	@Override
	public ProductResponse getProductById(long id) throws ProductException {
		
		MDC.put("userId", String.valueOf(id));

		String sql =  "SELECT * FROM Products WHERE ID = ?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setFloat(1, id);
			
			
			logger.trace("Product retreived");
			

			
			try(ResultSet rs = stmt.executeQuery()){
				
				if(rs.next()) {
					
					
					return new ProductResponse(
							rs.getLong("id"),
							rs.getString("name"),
							rs.getString("sku_code"),
							rs.getDouble("price")
							);
					
					

				}

				
			}
			
		}
		catch (SQLException e) {
			logger.error("unable to add the product");
			e.printStackTrace();	
		}
		return null;
	}

	@Override
	public boolean createProduct(ProductRequest productRequest) {
		String sql =  "INSERT INTO Products(name, sku_code, price) VALUES(?,?,?)";
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, productRequest.getName());
			stmt.setString(2, productRequest.getSkuCode());
			stmt.setFloat(3, productRequest.getPrice());
			
			int result = stmt.executeUpdate();
			
			if(result>0) {
				
				return true;	
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(ProductResponse productResponse) {
	    String sql = "UPDATE Products SET name = ?, sku_code = ?, price = ? WHERE id = ?";

	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {

	        stmt.setString(1, productResponse.getName());
	        stmt.setString(2, productResponse.getSkuCode());
	        stmt.setDouble(3, productResponse.getPrice());
	        stmt.setLong(4, productResponse.getId());

	        int result = stmt.executeUpdate();

	        if (result > 0) {
	            logger.info("Product with ID " + productResponse.getId() + " updated successfully.");
	            return true;
	        }

	    } catch (SQLException e) {
	        logger.error("Error updating product with ID " + productResponse.getId(), e);
	    }

	    return false;
	}


	@Override
	public boolean deleteProduct(long id) {
	    String sql = "DELETE FROM Products WHERE id = ?";

	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {

	        stmt.setLong(1, id);

	        int result = stmt.executeUpdate();

	        if (result > 0) {
	            logger.info("Product with ID " + id + " deleted successfully.");
	            return true;
	        }

	    } catch (SQLException e) {
	        logger.error("Error deleting product with ID " + id, e);
	    }

	    return false;
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		String sql =  "SELECT * FROM Products";
		
		List<ProductResponse> products = new ArrayList();
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt = con.prepareStatement(sql)){
						
			try(ResultSet rs = stmt.executeQuery()){
				
				ProductResponse response;
				
				while(rs.next()) {
					
					response = new  ProductResponse(
								rs.getLong("id"),
								rs.getString("name"),
								rs.getString("sku_code"),
								rs.getDouble("price")
								);
					
					products.add(response);
				}
				return products;	
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
