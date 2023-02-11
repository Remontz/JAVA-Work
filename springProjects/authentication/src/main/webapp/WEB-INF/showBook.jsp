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

        <title>Read Share</title>
    </head>
    <body>
        <h1>Welcome, <c:out value="${user.username}" />!</h1>
        <a href="/books">Back to the shelves!</a>
        
        <p><c:out value="${book.user.username}" /> read <c:out value="${book.title}" /> by <c:out value="${book.author}" />.</p>
        <p>Here are <c:out value="${book.user.username}" />'s thoughts:</p>

        <p><c:out value="${book.thoughts}" /></p>

        <a href="/logout">logout</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>