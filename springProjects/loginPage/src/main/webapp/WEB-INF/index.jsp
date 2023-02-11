<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h2>Welcome to Ninja Pizza</h2>
		<form action="/login"  method="POST">
			<h3>Log in here:</h3>
			<div>
				<label>email</label>
				<input type="text" name="email">
			</div>
			<div>
				<label>password</label>
				<input type="password" name="password">
			</div>
			<button>submit</button>
		</form>
	</body>


</html>