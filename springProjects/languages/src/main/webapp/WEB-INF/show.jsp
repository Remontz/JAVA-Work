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
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    
    <title><c:out value="${lanuage.name}"></c:out></title>
</head>
<body>
    <h1>Language Info</h1>

    <h6>Language #<c:out value="${language.id}"></c:out></h2>
    <h4>Name: <c:out value="${language.name}"></c:out></h6>
    <p>Language Creator: <c:out value="${language.creator}"></c:out></p>
    <p>Version: <c:out value="${language.version}"></c:out></p>


    <a href="/languages">Go Back!</a>
    <a href="/languages/edit/${language.id}">Edit</a>
    <a href="/languages/delete/${language.id}">Delete</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>