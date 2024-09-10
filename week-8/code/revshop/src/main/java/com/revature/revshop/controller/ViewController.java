package com.revature.revshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	@GetMapping("/home")
	 public String homeJsp(){
	        return "home";
	    }
	 @GetMapping("/login")
	 public String loginJsp(){
	        return "login";
	    }
	 @GetMapping("/dashboard")
	 public String dashboardJsp(){
	        return "dashboard";
	    }

}
