<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->

	<title>Edit Team</title>
</head>
<body>
	<h1>Edit the <c:out value="${team.name}" />'s </h1>
	
	<div class=editTeam>
		<form:form action="/teams/${team.id}/update" method='POST' modelAttribute="team" >
		<div class="form_input">
			<form:label path="city">Team City</form:label>
			<form:errors path="city" class="text-danger" />
			<form:input path="city" /> 
		</div>
		<div class="form_input">
			<form:label path="name">Team Name</form:label>
			<form:errors path="name" class="text-danger" />
			<form:input path="name" />
		
		<button>Edit Team</button>
		</form:form>
	</div>

    <a href="/">Dashboard</a>
	
	<script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>