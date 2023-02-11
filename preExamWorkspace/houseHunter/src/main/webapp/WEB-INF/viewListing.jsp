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

        <title>View Listing</title>
    </head>
    <body>
        <h1><c:out value="${listing.address}" /></h1>
        <a href="/">Dashboard</a>

        <p>Address: <c:out value="${listing.address}" /></p>
        <p>Listing Date: <c:out value="${listing.updatedAt}" /></p>
        <p>Price: <c:out value="${listing.price}" /></p>
        <div class="displayNotes">
            <h2>Notes: </h2>
                <c:forEach var="note" items="${allNotes}">
                    <p>Added by <c:out value="${note.user.username}" /></p>
                    <p>   - <c:out value="${note.content}" /></p>
                </c:forEach>
        </div>
        <div class="addNote">
            <form:form action="/note/create" method="POST" modelAttribute="note">
                <h2>Add Note:</h2>
                <div>
					<form:label class="form-label" path="content"> Note: </form:label>
					<form:input path="content" type="text" />
					<form:errors path="content" />
				</div>
                <div>
                    <form:select path="user">
                        <c:forEach var="user" items="${allUsers}">
                            <form:option value="${user.id}"><c:out value="${user.username}" /></form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <button>Add Note</button>
            </form:form>
        </div>
        <c:if test="${session.userid} == ${listing.user.id}">
            <a href="/listing/{listing.id}/edit">Edit</a>
            <a href="/listing/{listing.id}/delete">delete</a>
        </c:if>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>