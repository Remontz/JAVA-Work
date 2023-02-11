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
    <title>Muffins</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
</head>
<body>
    <h1>Edit a Muffin!</h1>
    <form:form action="/muffin/${muffin.id}/update" method="POST" modelAttribute="muffin">
        <input type="hidden" name="_method" value="put">
        <div>
            <form:label path="flavor">Flavor</form:label>
            <form:errors path="flavor" class="text-danger" />
            <form:input path="flavor" />
        </div>
        <div>
            <form:label path="frosting">Frosting</form:label>
            <form:errors path="frosting" class="text-warning" />
            <form:input path="frosting" />
        </div>
        <div>
            <form:label path="calories">Calories</form:label>
            <form:errors path="calories" class="text-success" />
            <form:input path="calories" />
        </div>
        <button>Submit!</button>
    </form:form>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>