package com.revature.revshop.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.model.Role;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;
import com.revature.revshop.service.UserService;
import com.revature.revshop.service.exception.UserServiceException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	
	private UserRepository userRepository;

	@Autowired
	 public UserTest(UserRepository userRepository) {
		 this.userRepository = userRepository;
	}
	
	private User user;
	private UserRequest userRequest;
	private UserResponse userResponse;
	
	
	
	
	@BeforeEach
	public void init() {
		 user = User.builder().id(1L).email("demo@gmail.com").password("demo").firstName("demo").lastName("demo").role(Role.BUYER).build();	
		 userRequest = UserRequest.builder().email("demo@gmail.com").password("demo").firstName("demo").lastName("demo").role(Role.BUYER).build();
		 userResponse = UserResponse.builder().id(1L).email("demo@gmail.com").firstName("demo").lastName("demo").role(Role.BUYER).build();
	}
	
	@Test
	public void createUser() throws UserServiceException {
	
	
	
	userService.createUser(userRequest);
	
	User createdUser = userRepository.findByEmail(userRequest.getEmail());
    assertNotNull(createdUser);
    assertEquals(userRequest.getEmail(), createdUser.getEmail());
    assertEquals(userRequest.getFirstName(), createdUser.getFirstName());
    assertEquals(userRequest.getLastName(), createdUser.getLastName());
    assertEquals(userRequest.getRole(), createdUser.getRole());
	}
	
	@Test
	public void getUserById() throws UserServiceException {
		
		//arrange
		user.setId(null);
		User userResult = userRepository.save(user);
		
		//act
		
		UserResponse userResponse = userService.getUserById(userResult.getId());
				
		//assert
		
		assertNotNull(userResponse);
		assertEquals(userResponse.getEmail(), user.getEmail());
		assertEquals(userResponse.getFirstName(), user.getFirstName());
		assertEquals(userResponse.getLastName(), user.getLastName());
		assertEquals(userResponse.getRole(), user.getRole());
		
		
	}
}
