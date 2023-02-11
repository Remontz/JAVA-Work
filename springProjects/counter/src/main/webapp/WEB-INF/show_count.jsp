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

		<title>Current visit count</title>	
	</head>
	<body>
		<p> You have visited <a>http://your_server</a> <c:out value = "${count}" /> times. </p>
		<p> <a href="/">Test another visit?</a> </p>
		<p> <a href="/reset/"> Reset </a> </p>
		<p> <a href="/double/">Increase the counter by 2.</a></p>
	
	
	
	
	
	
	
	
		<!-- For any Bootstrap that uses JS or jQuery -->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>