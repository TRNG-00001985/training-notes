package com.revature.revshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;
import com.revature.revshop.service.exception.UserServiceException;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class UserService {
	
private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	public boolean createUser(UserRequest userRequest) {
		
		try {
			
			User user = User.builder()
					.email(userRequest.getEmail())
					.firstName(userRequest.getFirstName())
					.lastName(userRequest.getLastName())
					.password(userRequest.getPassword())
					.role(userRequest.getRole())
					.build();
			
			userRepository.save(user);
			
			return true;	
			

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}

	
	public UserResponse getUserById(long id) throws UserServiceException {
		
		try {
			
			User user = userRepository.findById(id).get();
			
			System.out.println(user.toString());
			
			
			
			UserResponse userResponse = UserResponse.builder()
					.email(user.getEmail())
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.role(user.getRole())
					.id(user.getId())
					.build();
			
			return userResponse;
	
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new UserServiceException("unable to retrive the user with id: " + id);
		}
		
		
	}

	
	public UserResponse updateUserById(UserRequest userRequest, long id) {
		
		try {
		
		
		User user = User.builder()
				.email(userRequest.getEmail())
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.password(userRequest.getPassword())
				.role(userRequest.getRole())
				.id(id)
				.build();
		
		user = userRepository.save(user);
		
		
		
		
		System.out.println(user.toString());
		
		UserResponse userResponse = UserResponse.builder()
				.email(user.getEmail())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.role(user.getRole())
				.id(user.getId())
				.build();
		
		return userResponse;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
		
		
	}

	
	public boolean deleteUserById(long id) {
		
		
		try {
			
		userRepository.deleteById(id);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	
	public UserResponse login(String email, String password) {
		
		try {
			
			User user = userRepository.findByEmailAndPasswordCustomQuery(email, password);
			
			return UserResponse.builder()
					.email(user.getEmail())
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.role(user.getRole())
					.id(user.getId())
					.build();
			
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public List<UserResponse> getAllUsers() {
	
		
		List<User> users = userRepository.findAll();
		
		List<UserResponse> userResponses = users.stream().map(user -> mapToUserResponse(user)).toList();
		
		return userResponses;
	}
	
	public UserResponse mapToUserResponse(User user) {
		
		return UserResponse.builder()
				.email(user.getEmail())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.role(user.getRole())
				.id(user.getId())
				.build();
		
		
		
	}
	



}
