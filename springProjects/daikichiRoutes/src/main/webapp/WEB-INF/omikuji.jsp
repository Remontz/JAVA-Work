<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">

	</head>
	<body>
		<h1>Send an Omikuji!</h1>
		
		<form action="/daikichi/processFormData" method="POST">
			<div>
				<label>Pick any number from 5 to 25</label>
				<input type="number" name="number"/>
			</div>
			<div>
				<label>Enter the name of any city.</label>
				<input type="text" name="city"/>
			</div>
			<div>
				<label>Enter the name of any real person</label>
				<input type="text" name="person"/>
			</div>
			<div>
				<label>Enter professional endeavor or hobby:</label>
				<input type="text" name="hobby"/>
			</div>
			<div>
				<label>Enter any type of living thing</label>
				<input type="text" name="livingThing"/>
			</div>
			<div>
				<label>Say something nice to someone: </label>
				<input type="text" name="said"/>
			</div>
			<p>Send and show a friend</p>
			<button>submit</button>
		</form>
	
	
		<!-- For any Bootstrap that uses JS or jQuery -->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>