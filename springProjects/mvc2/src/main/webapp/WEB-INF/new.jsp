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

    <title>New Books</title>
</head>
<body>
    <h1>New Book</h1>
    <form:form action="/books" method="POST" modelAttribute="book"> <!--form:form exposes child tags to Binding-->
        <div>
            <form:label path="title">Title</form:label>
            <form:errors path="title" class="text-danger" />
            <form:input type="text" path="title" />
        </div>
        <div>
            <form:label path="description">Description</form:label>
            <form:errors path="description" class="text-danger" />
            <form:input type="text" path="description" />
        </div>
        <div>
            <form:label path="language">Language</form:label>
            <form:errors path="language" class="text-danger" />
            <form:input type="text" path="language" />
        </div>
        <div>
            <form:label path="numberOfPages">Number of Pages</form:label>
            <form:errors path="numberOfPages" class="text-danger" />
            <form:input type="number" path="numberOfPages" />
        </div>
        <button>Submit!</button>

    </form:form>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> 
</body>
</html>