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

		<title>Welcome</title>
	</head>
	<body>
		<h1>Welcome Page</h1>
		<p> Hi <c:out value="${email}"  /> </p>
		
		
		
		<!-- For any Bootstrap that uses JS or jQuery -->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>