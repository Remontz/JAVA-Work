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
    
    <title>Details</title>
</head>
<body>
    <a href="/dashboard">Dashboard</a>
    <p>Top Ten Songs:</p>
    <div>
        <p>Title        <c:out value="${song.title}"></c:out></p>
        <p>Artist        <c:out value="${song.artist}"></c:out></p>
        <p>Rating (1-10)        <c:out value="${song.rating}"></c:out></p>
        <p>By pressing "Delete" below this song will be removed from your database.</p>
    </div>
    <form action="/songs/${song.id}/delete" method="post">
        <input type="hidden" name="_method" value="delete" />
        <input type="submit" value="Delete" />
    </form>





    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>