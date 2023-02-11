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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->

    <title>Ninja</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/ninja/create" method="POST" modelAttribute="ninja">
        <div class="form_input">
            <form:label path="firstName">Firt Name</form:label>
            <form:errors path="firstName" />
            <form:input path="firstName" />
        </div>
        <div class="form_input">
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName" />
            <form:input path="lastName" />
        </div>
        <div class="form_input">
            <form:label path="age">Age</form:label>
            <form:errors path="age" />
            <form:input path="age" />
        </div>

        <form:select path="dojo">
            <c:forEach var="dojo" items="${allDojos}">
                <form:option value="${dojo.id}">
                    <c:out value="${dojo.name}" />
                </form:option>
            </c:forEach>
        </form:select>
        <button>Submit</button>
    </form:form>

    <a href="/dashboard">Go Back</a>



    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>