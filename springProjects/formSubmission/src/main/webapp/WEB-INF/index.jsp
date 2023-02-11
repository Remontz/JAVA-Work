<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- local CSS -->
		<link rel="stylesheet" type="text/css" href="/css/style.css">

		<title>Title</title>
	</head>
	<body>
		<h3>Login</h3>
		<form action="/login" method="GET">
			<label>Email</label>
			<input type="text" name="email" />
			<label>Password</label>
			<input type="password" name="password" />
			<input type="submit" value="Log In">
		</form>
		
		
		
		<!-- For any Bootstrap that uses JS or jQuery -->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>