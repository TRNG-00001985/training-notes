package com.revature.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	
	public UserResponse getUserById(@PathVariable long id) {
		
		return userService.getUserById(id);
		
		
	}
	
	@PostMapping
	@ResponseBody
	public boolean createUser(@RequestBody UserRequest userRequest) {
		
		try {
			
			return userService.createUser(userRequest);
			
		}
		catch(Exception e) {
			return false;
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password, HttpSession session) {
		
		UserResponse userResponse =  userService.login(email, password);
		
		if(userResponse!=null) {
			
			session.setAttribute("user", userResponse);
			System.out.println(userResponse);
			
			 return "redirect:/dashboard";
			
		}
		else {
			return "login";
		}
		
		
	}
}
