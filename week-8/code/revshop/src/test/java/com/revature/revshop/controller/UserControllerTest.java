package com.revature.revshop.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.model.Role;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;
import com.revature.revshop.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private UserService userService;
	
	
	private User user;
	private UserRequest userRequest;
	private UserResponse userResponse;
	
	
	//used to convert the object to JSON format
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	public void init() {
		 user = User.builder().id(1L).email("demo@gmail.com").password("demo").firstName("demo").lastName("demo").role(Role.BUYER).build();	
		 userRequest = UserRequest.builder().email("demo@gmail.com").password("demo").firstName("demo").lastName("demo").role(Role.BUYER).build();
		 userResponse = UserResponse.builder().id(1L).email("demo@gmail.com").firstName("demo").lastName("demo").role(Role.BUYER).build();
	}
	
	@Test
	public void UserController_CreateUser_ResturnTrue() throws Exception{
		
		
		BDDMockito.given(userService.createUser(ArgumentMatchers.any())).willReturn(true);
		
		ResultActions response = mockMvc.perform(post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userRequest)));
		
		response.andExpect(MockMvcResultMatchers.status().isCreated());
		
		
		
		
	}
	
	@Test
	public void UserController_GetUserByID_ReturnsCreatedUser() throws Exception {
		
		Long id = 1L;
		
		
		BDDMockito.given(userService.getUserById(ArgumentMatchers.anyLong())).willReturn(userResponse);
		
		ResultActions response = mockMvc.perform(get("/user/")
	            .contentType(MediaType.APPLICATION_JSON)
	            .param("id", String.valueOf(id)));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName",CoreMatchers.is(userResponse.getFirstName())));
		
	}
	
	@Test
	
	public void UserController_UpdateUserById_Returns_UserResponse() throws Exception {
		
		//arange
		
		Long id = 1L;
		
		
		//act 
		when(userService.updateUserById(Mockito.any(), Mockito.anyLong())).thenReturn(userResponse);
		
		ResultActions response = mockMvc.perform(put("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userRequest))
				.param("id", String.valueOf(id)));
		
		
		System.out.println(response);
		
		
		response.andExpect(MockMvcResultMatchers.status().isAccepted())
		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(userRequest.getFirstName())))
		.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(userRequest.getLastName())))
		.andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(userRequest.getEmail())))
		.andExpect(MockMvcResultMatchers.jsonPath("$.role", CoreMatchers.is(String.valueOf(userRequest.getRole()))));
	
		
	}
	
	@Test
	public void UserController_DeleteUserById_Returns_True() throws Exception{
		
	}
	
	
	
	

}
