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
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h1>Create an Author!</h1>
    <a href="/dashboard">back to the shelves</a>

    <form:form action="/authors/create" method="POST" modelAttribute="author">
        <div>
            <form:label path="name">Name:</form:label>
            <form:input path="name" type="text" />
            <form:errors path="name" />
        </div>
        <div>
            <form:label path="age"> Age: </form:label>
            <form:input path="age" type="text" />
            <form:errors path="age" />
        </div>
        <button>Submit</button>
    </form:form>
    

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>