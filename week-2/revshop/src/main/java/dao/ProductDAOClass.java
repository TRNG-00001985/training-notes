package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import dto.ProductRequest;
import dto.ProductResponse;
import utils.ConnectionFactory;

public class ProductDAOClass implements ProductDao{
	

	@Override
	public ProductResponse getProductById(long id) {
		String sql =  "SELECT * FROM Products WHERE ID = ?";
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setFloat(1, id);
			
			try(ResultSet rs = stmt.executeQuery()){
				
				if(rs.next()) {
					return new ProductResponse(
							rs.getLong("id"),
							rs.getString("name"),
							rs.getString("sku_code"),
							rs.getFloat("price")
							);
				}
				
			}
			
		}
		catch (SQLException e) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		String sql =  "SELECT * FROM Products";
		
		List<ProductResponse> products = new ArrayList();
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt = con.prepareStatement(sql)){
						
			try(ResultSet rs = stmt.executeQuery()){
				
				ProductResponse response = null;
				
				while(rs.next()) {
					
					response = new ProductResponse(
								rs.getLong("id"),
								rs.getString("name"),
								rs.getString("sku_code"),
								rs.getFloat("price")
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
