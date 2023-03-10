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

    <title>Dojo</title>
</head>
<body>
    <h1>Create Dojo</h1>

    <div class="createDojo">
        <form:form action="/dojo/create" method="POST" modelAttribute="dojo">
            <div class="form_input">
                <form:label path="name">Dojo Name</form:label>
                <form:errors path="name" class="text-danger" />
                <form:input path="name" />
            </div>


            <button>Submit</button>
        </form:form>
    </div>

    <a href="/dashboard">Go Back</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>