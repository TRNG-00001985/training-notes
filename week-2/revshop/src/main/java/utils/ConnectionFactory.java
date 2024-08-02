package utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	
	private Properties props = new Properties();
	
	private ConnectionFactory() {
		try {
			props.load(new FileReader("src/main/resources/db.properties"));
			
		}
		catch(IOException e ) {
			e.printStackTrace();		
		}	
	}
	
	public static ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		
		try {
			return DriverManager.getConnection(
					props.getProperty("url"),
					props.getProperty("username"),
					props.getProperty("password")
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//Class.forName("com.mysql.jdbc.Driver")
	//DriverManager.registerDriver()
	
	

}
