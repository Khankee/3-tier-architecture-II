<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<link rel="stylesheet" href="style.css">
		<title>Login Success Page</title>
	</head>
	<body>
	
	<div class = "converter">
		<h1>Converter</h1>
	</div>
		<%
			String user = session.getAttribute("CURRENT_USER") + "";
			String session_cookie = session.getId();
		%>
		<h3>Login Success</h3>
		<h4>Welcome: <%=user%></h4>
		<h4>Session ID: <%=session_cookie%></h4>
		<br><br>

			<!-- First method -->
		<div class = "converter-page">
			<div class="form">
				<h3>Enter any number</h3>
				<form action="Converter" method="post">
						<input type="text" placeholder ="Enter decimal number" name = "decimal-number" required>
						<button>convert</button>
				</form>
		
				
				<%
					String resultOctal = session.getAttribute("CONVERTER_RESULT_OCTAL") + "";
					String resultHexadecimal = session.getAttribute("CONVERTER_RESULT_HEXA") + "";
				%>
				<h4>Octal number - <%=resultOctal%></h4>
				<h4>Hexadecimal number - <%=resultHexadecimal%></h4>
				<form action="Logout" method="post">
				<button>Logout</button>
				</form>
			</div>
		</div>
		
	</body>
</html>