package dao;

import dto.UserRequest;
import dto.UserResponse;

public interface UserDAO{
	
	boolean createUser(UserRequest userRequest);
	UserResponse getUserById(long id);
	UserResponse updateUserById(UserRequest userRequest, long id);
	boolean deleteUserById(long id);
	UserResponse login(String email, String password);

}
