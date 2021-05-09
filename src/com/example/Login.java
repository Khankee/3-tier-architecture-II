package com.example;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private Authenticator authenticator = null;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		authenticator = new Authenticator(uname, pwd);
		
		
		if (authenticator.authenticateUser()) {
			
			request.getSession().setAttribute("CURRENT_USER", authenticator.getUsername());
			
			request.getSession().setMaxInactiveInterval(10); 
			
			request.getRequestDispatcher("/WEB-INF/user-welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("error", authenticator.getAuthenticationMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
} 
