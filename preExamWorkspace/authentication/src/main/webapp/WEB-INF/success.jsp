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
        <meta charset="ISO-8859-1">
   	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    	<link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->

        <title>Login & Registration</title>
    </head>
    <body>
        <h1>Welcome, <c:out value="${user.username}" />!</h1>
        <h3>Books from everyone's shelves:</h3>
        <a href="/books/new">Add to my shelf!</a>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author Name</th>
                    <th>Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${allBooks}">
                    <tr>
                        <td><c:out value="${book.id}" /></td>
                        <td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
                        <td><c:out value="${book.author}" /></td>
                        <td><c:out value="${book.user.username}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/logout">logout</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>