package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Converter")
public class Converter extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// request.getSession().setAttribute("CURRENT_USER", authenticator.getUsername());
		//String user = request.getSession().getAttribute("CURRENT_USER").toString();
		
		//System.out.println("Session data: " + user);
		
		String input = request.getParameter("decimal-number");
		int len = input.length();
		if (onlyDigits(input,len)) {
			System.out.println("Input: "+ input);
			int resultOctal = Integer.parseInt(input);
			int hex = Integer.parseInt(input);
			String resultHexadecimal;
			
			resultOctal = Integer.parseInt(DecimalToOctal(resultOctal));
			resultHexadecimal = DecimalToHexadecimal(hex);
			
			request.getSession().setAttribute("CONVERTER_RESULT_OCTAL", resultOctal);
			request.getSession().setAttribute("CONVERTER_RESULT_HEXA", resultHexadecimal);
			
			request.getRequestDispatcher("/WEB-INF/user-welcome.jsp").forward(request, response);
		}
		else {
			String resultOctal = "Please enter the number";
			String resultHexadecimal = "Please enter the number";
			
			request.getSession().setAttribute("CONVERTER_RESULT_OCTAL", resultOctal);
			request.getSession().setAttribute("CONVERTER_RESULT_HEXA", resultHexadecimal);
			
			request.getRequestDispatcher("/WEB-INF/user-welcome.jsp").forward(request, response);
		}
	}
	
	public static boolean onlyDigits(String user_input, int n) { //recursion
		if (n == 0) {
			return true;
		}
		
		if(user_input.charAt(0) >= '0' && user_input.charAt(0) <= '9') {
			return onlyDigits(user_input.substring(1), n-1); //here
		}
		else {
			return false;
		}
			
	}
	
	public static String DecimalToOctal(int decimal) { //user defined method which converts decimal to octal number and returns the value
		
		int reminder; 
		String octal = "";
		
		char octalchars[] = {'0','1','2','3','4','5','6','7'};
		
		while (decimal > 0) {
			reminder = decimal % 8;
			octal = octalchars[reminder] + octal;
			decimal = decimal / 8;
		}
		return octal;
	}
	
	public static String DecimalToHexadecimal(int decimal) {//user defined method which converts decimal to hexadecimal number and returns the value
		int reminder; 
		String hexadecimal = "";
		
		char hexadecimalchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		while (decimal > 0) {
			reminder = decimal % 16;
			hexadecimal = hexadecimalchars[reminder] + hexadecimal;
			decimal = decimal / 16;
		}
		return hexadecimal;
	}
	

}
