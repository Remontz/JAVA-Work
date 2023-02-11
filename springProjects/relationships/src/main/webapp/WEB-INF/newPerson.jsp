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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->

    <title>New Person</title>
</head>
<body>
    <h1>Test New Person</h1>
    <form:form action="/person/create" method="POST" modelAttribute="person">
        <div class="form_input">
            <form:label path="firstName">Firt Name</form:label>
            <form:errors path="firstName" />
            <form:input path="firstName" />
        </div>
        <div class="form_input">
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName" />
            <form:input path="lastName" />
        </div>
        <button>Submit</button>        
    </form:form>

    <a href="/dashboard">Go Back</a>



    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>