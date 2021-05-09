<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
	<head>  
		<meta charset="ISO-8859-1">  
		<link rel="stylesheet" href="./style.css">
		<title>Home page / Login </title>  
	</head>  
	<body>
	<div class = "converter">
		<h1>Converter</h1>
	</div>
	<div class = "login-page">
		<div class="form">
			<form action="Login" method = "post">  
				<input type="text" placeholder="Enter your username" name="uname" required>
				<input type="password" placeholder="Enter your password" name="pwd" required>
				<p style = "color:red"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>  
				<button>login</button> 
				<p class="message">let's <a href="./user-registration.jsp">register</a></p> 
			</form>
		</div>
	</div>  
	</body>  
</html> 