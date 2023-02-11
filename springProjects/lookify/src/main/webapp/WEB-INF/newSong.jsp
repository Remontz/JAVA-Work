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
    
    <title>Lookify!</title>
</head>
<body>
    <h1>Welcome to Lookify!</h1>
    <h2>New Song</h2>
    <a href="/dashboard">Dashboard</a>

    <form:form action="/songs/create" method="post" modelAttribute="song">
        <div>
            <form:label path="title">Song Title: </form:label>
            <form:errors path="title" class="text-warning" />
            <form:input type="text" path="title" />
        </div>
        <div>
            <form:label path="artist">Artist/Band: </form:label>
            <form:errors path="artist" class="text-danger" />
            <form:input type="text" path="artist" />
        </div>
        <div>
            <form:label path="rating">Rating: </form:label>
            <form:errors path="rating" class="text-danger" />
            <form:input type="number" path="rating" />
        </div>
        <button>Submit!</button>
    </form:form>




    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>