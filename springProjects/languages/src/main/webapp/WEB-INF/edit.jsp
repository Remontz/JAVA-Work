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

        <title>Languages</title>
    </head>
    <body>

        <form:form action="/languages/update/${language.id}" method="post" modelAttribute="language">
            <input type="hidden" name="_method" value="put" />
            <div>
                <form:label path="name">Language Name: </form:label>
                <form:errors path="name" class="text-danger" />
                <form:input type="text" path="name" />
            </div>
            <div>
                <form:label path="creator">Creator: </form:label>
                <form:errors path="creator" class="text-danger" />
                <form:input type="text" path="creator" />
            </div>
            <div>
                <form:label path="version">Version: </form:label>
                <form:errors path="version" class="text-danger" />
                <form:input type="text" path="version" />
            </div>
            <button>Submit!</button>
        </form:form>

    	<script src="/webjars/jquery/jquery.min.js"></script>
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>