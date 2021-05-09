<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" href="style.css">
	<title>Registration</title>
	</head>
		<body>
		<div class = "converter">
			<h1>Converter</h1>
		</div>
		<div class= "login-page">
			<div class = "form">
				<form action = "registration" method = "post">
					<input type="text" placeholder = "Login" name = "first_name"/>
				    <input type="password" placeholder = "Password" name = "password"/>
				    <input type="password" placeholder = "Rewrite-Password" name = "passwordrepeat"/>
				    <p style = "color:red"><%= request.getAttribute("error_2") == null ? "" : request.getAttribute("error_2") %></p>
				    <button>create</button>
				    <p class="message">Already registered? <a href="./index.jsp">login</a></p>
				</form>
			</div>
		</div>
		</body>
</html>