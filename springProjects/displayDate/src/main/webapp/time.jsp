<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="UTF-8" />
			<!-- for Bootstrap CSS -->
			<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
			<!-- local CSS -->
			<link rel="stylesheet" type="text/css" href="/css/style.css">

			<title>Time</title>
		</head>
		<body>
			<div>
				<p>Time: <c:out value="${hour}"></c:out>:<c:out value="${minute}"></c:out> <c:out value="${amPM}"></c:out></p>
			</div>
		
		
		
					<!-- For any Bootstrap that uses JS or jQuery -->
			<script src="/webjars/jquery/jquery.min.js"></script>
			<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		</body>