package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.Role;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@GetMapping()
	public UserResponse getUserByID(@RequestParam Long id) {
		
		
		return UserResponse.builder()
				.id(id)
				.email("demo@gmail.com")
				.firstName("John")
				.lastName("Doe")
				.role(Role.BUYER)
				.build();	
		
	}
	
	@PostMapping
	public boolean createUser(@RequestBody UserRequest userRequest) {
		
		if(userRequest.getEmail()!=null) {
			
			System.out.println(userRequest.toString());
			return true;
		}
		
		return false;
		
	}
	@GetMapping("all")
	public List<UserResponse> getAllUSers() {
		
		List<UserResponse> users = new ArrayList();
		users.add(UserResponse.builder()
				.id(1L)
				.email("demo@gmail.com")
				.firstName("John")
				.lastName("Doe")
				.role(Role.BUYER)
				.build());
		
		return users;
		
	}
	
	


}
