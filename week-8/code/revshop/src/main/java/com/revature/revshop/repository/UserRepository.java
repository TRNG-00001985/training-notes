package com.revature.revshop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.revshop.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.email= :email AND u.password= :password")
	User findByEmailAndPasswordCustomQuery(String email, String password);


	

}