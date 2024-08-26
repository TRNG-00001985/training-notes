package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/user/*")
public class UserController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// logged in 
		
		HttpSession session = req.getSession();
		
		session.setAttribute("id", 1);
		
		Cookie cookie = new Cookie("id", "1");
		
		resp.addCookie(cookie);
		
		PrintWriter out = resp.getWriter();
		
		out.println("user logged in with id: " + session.getAttribute("id"));
		
		
		resp.sendRedirect("/revshop-servelets/dashboard.jsp");
		
		// TODO Auto-generated method stub
	}

}
