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

        <title>House Hunter Dashboard</title>
    </head>
    <body>
        <h1>Welcome, <c:out value="${user.username}" />!</h1>
        <a href="/logout">logout</a>

        <table>
            <thead>
                <tr>
                    <th>Address</th>
                    <th>Listed On</th>
                    <th>Added By</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="listing" items="${allListings}">
                    <tr>
                        <td><a href="/listing/${listing.id}"><c:out value="${listing.address}" /></a></td>
                        <td><c:out value="${listing.updatedAt}" /></td>
                        <td><c:out value="${listing.user.username}" /></td>
                        <td><c:out value="${listing.price}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form:form action="/listing/new" method="GET">
            <button>Add Listing</button>
        </form:form>


    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>