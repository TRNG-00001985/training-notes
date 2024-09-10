package com.revature.revshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.model.Role;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;
import com.revature.revshop.service.exception.UserServiceException;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	private User user;
	private UserRequest userRequest;
	private UserResponse userResponse;
	
	@BeforeEach
	void init() {
		
		 this.user = User.builder().id(1L).email("demo@gmail.com").password("demo").firstName("demo").lastName("demo").role(Role.BUYER).build();
		 this.userRequest = UserRequest.builder()
				.email("demo@gmail.com")
				.password("demo")
				.firstName("demo")
				.lastName("demo")
				.role(Role.BUYER)
				.build();
		
		 this.userResponse = UserResponse.builder()
				.id(1L)
				.email("demo@gmail.com")
				.firstName("demo")
				.lastName("demo")
				.role(Role.BUYER)
				.build();
		
	}
	
	@Test
	public void UserService_CreateUser_Returns_True() throws UserServiceException {
				
		//act
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		
		
		boolean result = userService.createUser(userRequest);
		
		//assert
				
		Assertions.assertThat(result).isTrue();
		verify(userRepository, times(1)).save(Mockito.any(User.class));

		
		
		
	}
	
	@Test
	public void UserService_GetUserById_Returns_UserResponse() throws UserServiceException {
		
		//arrange
		
		Long id = 1L;
		
		
		
		//act		
		when(userRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(user));
		
		UserResponse result = userService.getUserById(id);
		
		//assert
		assertEquals(userResponse.getId(), result.getId());
		assertEquals(userResponse.getEmail(), result.getEmail());
		assertEquals(userResponse.getFirstName(), result.getFirstName());
		assertEquals(userResponse.getLastName(), result.getLastName());
		assertEquals(userResponse.getRole(), result.getRole());
		
		verify(userRepository, times(1)).findById(Mockito.any(Long.class));

		
	}
	
	@Test
	public void UserService_UpdateUser_Returns_UserResponse() {
		
		//arrange
		
		Long id = 1L;
		
		//act
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		
		UserResponse userResponseResult = userService.updateUserById(userRequest, id);
		
		//assert
		
		assertEquals(userResponseResult.getFirstName(), userRequest.getFirstName());
		assertEquals(userResponseResult.getLastName(), userRequest.getLastName());
		assertEquals(userResponseResult.getRole(), userRequest.getRole());
		assertEquals(userResponseResult.getEmail(), userRequest.getEmail());
		assertEquals(userResponseResult.getId(), id);
		
		verify(userRepository, times(1)).save(Mockito.any(User.class));

		
	}
	
	@Test
	public void UserService_DeleteUser_Reteruns_True() {
		
		
		//arrage
		
		Long id = 1L;
		
		//act
		
		Boolean result = userService.deleteUserById(id);
		
		//assert
		
		assertTrue(result);

		
	}
	
	
	
	

}
