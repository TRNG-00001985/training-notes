package com.revature.revshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

import com.revature.revshop.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
@PropertySource("application-test.properties")
class RevshopApplicationTests {

	@Test
	void contextLoads() {
	}
	
	

	 

}
