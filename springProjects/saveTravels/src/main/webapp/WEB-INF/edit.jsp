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
    <h2>Edit an expense: </h2>

    <form:form action="/expenses/update/${expense.id}" method="post" modelAttribute="expense">
        <input type="hidden" name="_method" value="put" />
        <div>
            <form:label path="name">Expense Name: </form:label>
            <form:errors path="name" class="text-danger" />
            <form:input type="text" path="name" />
        </div>
        <div>
            <form:label path="vendor">Vendor: </form:label>
            <form:errors path="vendor" class="text-danger" />
            <form:input type="text" path="vendor" />
        </div>
        <div>
            <form:label path="amount">Amount: </form:label>
            <form:errors path="amount" class="text-danger" />
            <form:input type="number" step="0.01" path="amount" />
        </div>
        <div>
            <form:label path="description">Description: </form:label>
            <form:errors path="description" class="text-danger" />
            <form:input type="text" path="description" />
        </div>
        <button>Submit!</button>
    </form:form>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>