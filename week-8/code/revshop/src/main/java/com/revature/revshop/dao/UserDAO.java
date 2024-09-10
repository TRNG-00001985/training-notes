package com.revature.revshop.dao;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;


public interface UserDAO{
	
	boolean createUser(UserRequest userRequest);
	UserResponse getUserById(long id);
	UserResponse updateUserById(UserRequest userRequest, long id);
	boolean deleteUserById(long id);
	UserResponse login(String email, String password);
	

}
