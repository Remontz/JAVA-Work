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

        <title>View Player</title>
    </head>
    <body>
        <h1>Welcome to <c:out value="${player.firstName}" /> <c:out value="${player.lastName}" />'s Page!</h1>
        <a href="/coaches/${coach.id}/edit">Edit Player</a>

        <p><c:out value="${player.position}" /></p>
        <p><c:out value="${player.firstName}" /> is <c:out value="${player.age}" /> years old -- currently wearing #<c:out value="${player.jerseyNum}" /> for the <c:out value="${player.team.city}" /> <c:out value="${player.team.name}" /></p>

        <a href="/">Go Back</a>
        <a href="/coaches/new">Create a new Coach</a>
        <a href="/players/new">Create a new Player</a>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>