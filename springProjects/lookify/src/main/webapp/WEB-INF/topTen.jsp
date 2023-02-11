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
    
    <title>Search</title>
</head>
<body>
    <p>Top Ten Songs:</p>
    <div>
        <ol>
            <c:forEach var="song" items="${topTenSongs}">
                <li>
                    <p>Rating: <c:out value="${song.rating}"></c:out> - <a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a> - <c:out value="${song.artist}"></c:out></p>
                </li>
            </c:forEach>
        </ol>
    </div>

    <a href="/dashboard">Dashboard</a>



    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>