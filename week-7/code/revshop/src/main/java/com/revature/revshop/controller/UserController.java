package com.revature.revshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.service.UserService;
import com.revature.revshop.service.exception.UserServiceException;


@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Boolean> createUser(@RequestBody UserRequest userRequest) throws Exception {
		
		try {
			
			boolean response = userService.createUser(userRequest);
			
			
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			throw new Exception("unable to create user");
		}
		
	}
	//@GetMapping
	//@ResponseStatus(HttpStatus.ACCEPTED)
//try -catch
//	public ResponseEntity<UserResponse> getUserById(@RequestParam long id) {
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//		
//		return new ResponseEntity<>(userService.getUserById(id), headers, HttpStatus.OK);
//		}
//		catch(Exception e) {
//			
//			throw new HttpClientErrorException(HttpStatusCode.valueOf(500));
//			
//		}
//	}
	

//	// ExceptionHandeler in controller
//	
//	
//	@ExceptionHandler(UserServiceException.class)
//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	public void handleUserServiceException() {
//		
//	}
//	
//	@GetMapping
//	public ResponseEntity<UserResponse> getUserById(@RequestParam long id) throws UserServiceException {
//	
//	HttpHeaders headers = new HttpHeaders();
//	
//	
//	
//	return new ResponseEntity<>(userService.getUserById(id), headers, HttpStatus.OK);
//}
	
	
	@GetMapping
	public ResponseEntity<UserResponse> getUserById(@RequestParam long id) throws UserServiceException {
	
	HttpHeaders headers = new HttpHeaders();
	
	
	
	
	return new ResponseEntity<>(userService.getUserById(id), headers, HttpStatus.OK);
	
}
	
	
	
	@PutMapping
	public ResponseEntity<UserResponse> updateUserById(@RequestBody UserRequest userRequest, @RequestParam long id) throws Exception {
		
		try {
			return  new ResponseEntity<>(userService.updateUserById(userRequest, id), HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			throw new Exception("unable to create the user");
		}
		
	}
	@DeleteMapping
	public Boolean deleteUserById(@RequestParam long id) {
		
		return userService.deleteUserById(id);
	}
	
	@PostMapping("login")
	public UserResponse login(@RequestParam String email,@RequestParam String password ) {
		
		return userService.login(email, password);
		
	}
	
	@GetMapping("all")
	public ResponseEntity<List<UserResponse>> getAllUsers(){
		
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		
	}

}
