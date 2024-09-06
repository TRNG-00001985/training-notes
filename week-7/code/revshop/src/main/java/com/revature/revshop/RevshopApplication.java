package com.revature.revshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RevshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevshopApplication.class, args);
	}

}
