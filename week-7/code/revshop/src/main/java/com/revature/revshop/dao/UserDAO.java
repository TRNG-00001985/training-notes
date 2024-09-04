package com.revature.revshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

import org.hibernate.Transaction;

@Component
public class UserDAO{
	
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserDAO(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(value = TxType.REQUIRES_NEW, rollbackOn = Exception.class)
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
			
			
			

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}

	
	public UserResponse getUserById(long id) {
		
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
		}
		
		
		return null;
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
		
		userRepository.save(user);
		
		
		
		user = userRepository.findById(id).get();
		
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
		
		Pageable pagebale = PageRequest.of(0, 4);
		
		List<User> users = userRepository.findAll(Sort.by("email"));
		
		
		for(User p: users) {
			
			System.out.println(p.toString());
			
		}
		
		
		return null;
	}

}
