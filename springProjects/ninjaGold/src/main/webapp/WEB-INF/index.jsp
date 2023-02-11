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

		<title>NINJA GOLD GAME</title>
	</head>
	<body>
		<h1>Ninja Gold</h1>
		
		<div class="goldCounter">
			<h3>Your Gold: </h3>
			<h3><c:out value="${gold}"/></h3>		
		</div>
		<div class="main">	
			<div class="farmBox">
				<h3>Farm</h3>
				<h4>(earns 10-20 gold)</h4>
				<form action="/processFormData" method="POST">
					<div>
					<input type="hidden" name="place" value="farm"/>
					</div>
					<button>Find Gold!</button>
				</form>
			</div><!-- /farmBox -->
			<div class="caveBox">
				<h3>Cave</h3>
				<h4>(earns t-10 gold)</h4>
				<form action="/processFormData" method="POST">
					<div>
					<input type="hidden" name="place" value="cave"/>
					</div>
					<button>Find Gold!</button>
				</form>
			</div><!-- /caveBox -->
			<div class="houseBox">
				<h3>House</h3>
				<h4>(earns 2-5 gold)</h4>
				<form action="/processFormData" method="POST">
					<div>
					<input type="hidden" name="place" value="house"/>
					</div>
					<button>Find Gold!</button>
				</form>
			</div><!-- /houseBox -->
			<div class="questBox">
				<h3>Quest</h3>
				<h4>(earns or loses 0-50 gold)</h4>
				<form action="/processFormData" method="POST">
					<div>
					<input type="hidden" name="place" value="quest"/>
					</div>
					<button>Find Gold!</button>
				</form>
			</div><!-- /questBox -->
		</div><!-- /Main -->
		<div class="activities">
			<h3>Activities: </h3>
			<div class="textBox">
				<c:forEach var="event" items="${result}">
				<p> <c:out value="${event}"/> </p>
				</c:forEach>
			</div>
		</div>
		
	
	
		<!-- For any Bootstrap that uses JS or jQuery -->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>