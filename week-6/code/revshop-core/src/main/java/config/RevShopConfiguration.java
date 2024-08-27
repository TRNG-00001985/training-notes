package config;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dao.UserDAOImpl;
import service.UserService;
import utils.ConnectionFactory;

@Configuration
public class RevShopConfiguration {
	
	@Bean
	@Scope("prototype")
	public UserDAOImpl userDao() {
		
		return new UserDAOImpl();
		
	}
	
	@Bean
	public UserService userService() {
		return new UserService(userDao());
	}
	
	

}
