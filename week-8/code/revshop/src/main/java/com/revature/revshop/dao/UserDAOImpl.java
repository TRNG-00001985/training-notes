package com.revature.revshop.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.revature.revshop.dto.UserRequest;
import com.revature.revshop.dto.UserResponse;
import com.revature.revshop.model.Role;
import com.revature.revshop.model.User;

import jakarta.transaction.Transactional;



@Repository
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public boolean createUser(UserRequest userRequest) {
		System.out.println(userRequest.toString());

		
		Session session = sessionFactory.openSession();
		System.out.println(userRequest.toString());

		Transaction tx = session.beginTransaction();
		
		try{
			
			User user = User.builder()
					.email(userRequest.getEmail())
					.password(userRequest.getPassword())
					.firstName(userRequest.getFirstName())
					.lastName(userRequest.getLastName())
					.role(userRequest.getRole())
					.build();
			
			session.save(user);
			
			
			
			tx.commit();
			
			return true;
			
		}
		catch (Exception e) {
			
		}
		finally {
			session.close();
		}
		return false;
	}

	@Override
	public UserResponse getUserById(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			User user = session.get(User.class, id);
			
			 UserResponse userResponse = UserResponse.builder()
					 .id(user.getId())
					.email(user.getEmail())
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.role(user.getRole())
					.build();
			
			
			tx.commit();
			
			return userResponse;
			
		}
		catch (Exception e) {
			
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public UserResponse updateUserById(UserRequest userRequest, long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			User user = User.builder()
					.id(id)
					.email(userRequest.getEmail())
					.password(userRequest.getPassword())
					.firstName(userRequest.getFirstName())
					.lastName(userRequest.getLastName())
					.role(userRequest.getRole())
					.build();
			
			session.saveOrUpdate(user);
			
		}
		catch (Exception e) {
			
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteUserById(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			User user = session.get(User.class, id);
			
			
			session.remove(user);
			
			return true;
			
			
			
		}
		catch (Exception e) {
			
		}
		finally {
			session.close();
		}
		return false;
	}

	@Override
	public UserResponse login(String email, String password) {
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//String hql = "FROM User u WHERE u.email= :email AND u.password= :password";
		
		String jpql = "SELECT u FROM User u WHERE u.email= :email AND u.password= :password";
		
		//String nq = "SELECT u FROM User u WHERE u.email=?1 AND u.password=?2";

		
		
		
		try {
			System.out.println(password);
			
			/*User user =  (User) session.createQuery(hql)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();*/
					
			
			User user = session.createQuery(jpql, User.class)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult(); 
			
			/*User user = session.createQuery(nq, User.class)
					.setParameter(1, email)
					.setParameter(2, password)
					.getSingleResult();*/
			
//			CriteriaBuilder cb = session.getCriteriaBuilder();
//			CriteriaQuery<User> cq = cb.createQuery(User.class);
//			
//			Root<User> user = cq.from(User.class);
//
//		    cq.select(user)
//		      .where(cb.and(
//		          cb.equal(user.get("email"), email),
//		          cb.equal(user.get("password"), password)));
//		    
//		    User result = session.createQuery(cq).getSingleResult();
			
			
			System.out.println(user.toString());
			tx.commit();
			
//			System.out.println(result.toString());
//			
//			return UserResponse.builder()
//					.email(result.getEmail())
//					.firstName(result.getFirstName())
//					.lastName(result.getLastName())
//					.role(result.getRole())
//					.id(result.getId())
//					.build();
			
			
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
		session.close();
		return null;
	}

	
	
	

}
