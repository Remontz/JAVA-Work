<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- local CSS -->
		<link rel="stylesheet" type="text/css" href="daikichiRoutes/src/main/webapp/style.css">

		<title>Personalized Omikjuji</title>
	</head>
	<body>
		<h1>Here's Your Omikuji</h1>
		<div class="blueBox">
			<h3> <c:out value="${result}" /></h3>
		</div>
		
		<p> <a href="/daikichi/omikuji/">Go Back</a> </p>

	
		<!-- For any Bootstrap that uses JS or jQuery -->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>