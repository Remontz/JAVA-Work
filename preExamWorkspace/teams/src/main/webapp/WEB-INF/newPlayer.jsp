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

	<title>New Player</title>
</head>
<body>
	<h1>Create a new Player</h1>
	
	<div class=createPlayer>
		<form:form action="/players/create" method='POST' modelAttribute="player">
		<div class="form_input">
			<form:label path="firstName"> First Name</form:label>
			<form:errors path="firstName" class="text-danger" />
			<form:input path="firstName" />
		</div>
		<div class="form_input">
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName" class="text-danger" />
			<form:input path="lastName" />
		</div>
		<div class="form_input">
			<form:label path="age">Age</form:label>
			<form:errors path="age" class="text-danger" />
			<form:input type="number" path="age" />
		</div>
		<div class="form_input">
            <form:label path="position">Position</form:label>
			<form:errors path="position" class="text-danger" />
			<form:input path="position" />
		</div>
        <div class="form_input">
            <form:label path="jerseyNum">Jersey Number</form:label>
            <form:errors path="jerseyNum" class="text-danger" />
            <form:input type="number" path="jerseyNum" />
        </div>
        <div class="form_input">
            <form:select path="team">
                <c:forEach var="team" items="${allTeams}">
                    <form:option value="${team.id}"><c:out value="${team.city}"/> <c:out value="${team.name}" /></form:option>
                </c:forEach>
            </form:select>
        </div>
		<button>Create Player</button>
		</form:form>
	</div>
	<a href="/">Go Back</a>
	<script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>