package com.revature.revshop.service;

import org.springframework.stereotype.Service;

import com.revature.revshop.dao.UserDAOImpl;
import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;

@Service
public class UserService {
	

	
	private UserDAOImpl userDAO;

    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }
    
    

    public boolean createUser(UserRequest userRequest) {
        return userDAO.createUser(userRequest);
    }

    
    public UserResponse getUserById(long id) {
        return userDAO.getUserById(id);
    }

    
    public UserResponse updateUserById(UserRequest userRequest, long id) {
        return userDAO.updateUserById(userRequest, id);
    }

    
    public boolean deleteUserById(long id) {
        return userDAO.deleteUserById(id);
    }

    
    public UserResponse login(String email, String password) {
        return userDAO.login(email, password);
    }
    


}

