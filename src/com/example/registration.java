package com.example;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class registration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String newusername = request.getParameter("first_name");
		String newpassword = request.getParameter("password");
		String passwordrepeat = request.getParameter("passwordrepeat");
		
		if (newpassword.equals(passwordrepeat)) {
			createinfo(newusername + "_" + newpassword);
			
			System.out.println( newusername + newpassword);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("error_2", getAuthenticationMessage());
			request.getRequestDispatcher("/user-registration.jsp").forward(request, response);
		}
		
		
	}
	
	public static void createinfo(String usernameandpass) throws IOException {
		FileWriter writehandle = new FileWriter("C:\\Users\\Арухан\\Desktop\\CS 1 year\\2020-2021-team-i\\database\\"+ usernameandpass +".txt");
		BufferedWriter bw = new BufferedWriter(writehandle);
		
		bw.write(usernameandpass);
		
		bw.close();
		writehandle.close();
	}
	
	public String getAuthenticationMessage(){
		return "Passwords does not match";
	}

}
