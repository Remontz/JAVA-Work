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

        <title>Book Share</title>
    </head>
    <body>
        <h1>Add a Book to Your Shelf! <c:out value="${user.username}" />!</h1>
        <a href="/books">back to the shelves</a>

        <form:form action="/books/create" method="POST" modelAttribute="book" class="col-sm">
            <div>
				<form:label path="title"> Title </form:label>
				<form:input path="title" type="text" />
				<form:errors path="title" />
			</div>
            <div>
				<form:label path="author"> Author </form:label>
				<form:input path="author" type="text" />
				<form:errors path="author" />
			</div>
            <div>
				<form:label path="thoughts"> My Thoughts </form:label>
				<form:input path="thoughts" type="thoughts" />
				<form:errors path="thoughts" />
			</div>
			<button>Create Book</button>
		</form:form>


        <a href="/logout">logout</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>