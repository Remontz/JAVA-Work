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
    
    <title>Save Travels</title>
</head>
<body>
    <h1>Travel Expenses</h1>

    <h2>Expense <c:out value="${expense.id}"></c:out></h2>
    <h6>Expense Name: <c:out value="${expense.name}"></c:out></h6>
    <p>Expense Description: <c:out value="${expense.description}"></c:out></p>
    <p>Vendor: <c:out value="${expense.vendor}"></c:out></p>
    <p>Amount Spent: <c:out value="${expense.amount}"></c:out></p>

    <a href="/expenses">Go Back!</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>