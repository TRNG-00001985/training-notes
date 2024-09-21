package com.revature.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class DemoController {
	
	@Value("${user}")
	private String user;
	
	@Value("${role}")
	private String role;
	
	@GetMapping
	public String getConfig() {
		return user + " "  +role;
	}

}
