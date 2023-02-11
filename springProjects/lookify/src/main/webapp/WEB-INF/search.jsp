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
    
    <title>Search!</title>
</head>
<body>
    <p>Songs by artist: <c:out value="${search}"></c:out> </p>

    <form action="/search" method="post" >
        <input type="text" name="search" placeholder="${search}" />
        <button>Search Artists</button>
    </form>

    <a href="/dashboard">Dashboard</a>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="song" items="${songs}">
                <tr>
                    <td><c:out value="${song.title}"></c:out></td>
                    <td><c:out value="${song.rating}"></c:out></td>
                    <td><a href="/songs/${song.id}/delete">Delete?</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>





    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>