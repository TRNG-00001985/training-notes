package service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.UserDAOImpl;
import dto.UserRequest;
import dto.UserResponse;



@Service
public class UserService {
	
	@PostConstruct
	private void init() {
		
		System.out.println("User service post construct");

	}
	
	private UserDAOImpl userDAO;

    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }
    
    
    @Lookup
    public UserDAOImpl userDao() {
    	return null;
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
    
    @PreDestroy
    void destroy(){
    	
    	System.out.println("user service pre destroy");
    	
    }
    

}

