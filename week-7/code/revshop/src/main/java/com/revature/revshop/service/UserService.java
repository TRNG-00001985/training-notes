package com.revature.revshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.revshop.dao.UserDAO;
import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;

@Service
public class UserService {
	
	private UserDAO userDao;
	
	@Autowired
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	
	public boolean createUser(UserRequest userRequest) {
		
		return userDao.createUser(userRequest);
		
		
	}
	
	public UserResponse getUserById(long id) {
		return userDao.getUserById(id);
	}
	
	public UserResponse updateUserById(UserRequest userRequest, long id) {
		return userDao.updateUserById( userRequest,  id);
	}
	public boolean deleteUserById(long id) {
		return userDao.deleteUserById(id);
	}
	
	public UserResponse login(String email, String password) {
		return userDao.login(email, password);
	}



	public List<UserResponse> getAllUsers() {
		
		return userDao.getAllUsers();
		
	}

}
