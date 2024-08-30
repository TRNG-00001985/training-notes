package com.revature.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.service.UserService;


@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public boolean createUser(@RequestBody UserRequest userRequest) {
		
		try {
			return userService.createUser(userRequest);
		}
		catch(Exception e) {
			return false;
		}
		
	}
	@GetMapping
	public UserResponse getUserById(@RequestParam long id) {
		
		return userService.getUserById(id);
	}
	
	@PutMapping
	public UserResponse updateUserById(@RequestBody UserRequest userRequest, @RequestParam long id) {
		
		try {
			return userService.updateUserById(userRequest, id);
		}
		catch(Exception e) {
			return null;
		}
		
	}
	@DeleteMapping
	public boolean deleteUserById(@RequestParam long id) {
		
		return userService.deleteUserById(id);
	}
	
	@GetMapping("login")
	public UserResponse login(@RequestParam String email,@RequestParam String password ) {
		
		return userService.login(email, password);
		
	}
	
	

}
