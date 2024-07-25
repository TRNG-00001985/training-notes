package controller;

import java.rmi.ServerException;

import service.LoginService;

public class LoginController {
	
	private final LoginService loginService = new LoginService();
	
	
	public void login() {
		
		try {
			loginService.login();
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public static void main(String[] args) {
		
		LoginController lc = new LoginController();
		
		lc.login();
		
	}

}
