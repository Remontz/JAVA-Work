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
    <h1>Add a Book to Your Shelf!</h1>
    <a href="/dashboard">back to the shelves</a>

    <form:form action="/books/create" method="POST" modelAttribute="book">
        <div>
            <form:input type="hidden" path="user" value="${user.id}" />
        </div>
        <div>
            <form:label path="title">Title</form:label>
            <form:input path="title" type="text" />
            <form:errors path="title" />
        </div>
        <div class="author">
            <p>Select or Create an Author?</p>
            <a href="/authors/add">Click here to create an author.</a>
            <div id="select">
                <form:select path="author">
                    <c:forEach var="author" items="${allAuthors}">
                        <form:option value="${author.id}">
                            <c:out value="${author.name}" />
                        </form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div>
            <form:label path="thoughts"> My Thoughts </form:label>
            <form:input path="thoughts" type="text" />
            <form:errors path="thoughts" />
        </div>
        <button>Submit</button>
    </form:form>
    

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>