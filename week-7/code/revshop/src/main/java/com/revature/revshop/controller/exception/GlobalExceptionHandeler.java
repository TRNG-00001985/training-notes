package com.revature.revshop.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.revshop.service.exception.UserServiceException;

@ControllerAdvice
public class GlobalExceptionHandeler {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public void handleException() {
		
	}
	
	

}
