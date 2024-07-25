package service;

import java.io.FileNotFoundException;
import java.rmi.ServerException;

public class LoginService {
	
	public void login() throws ServerException {
		
		try {
		throw new FileNotFoundException();
		}
		catch(Exception e) {
			throw new ServerException("Unable to login- user does not exist");
		}
	}
	

}
