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

    <title>New License</title>
</head>
<body>
    <h1>Test New License</h1>

    <div class="createLicense">
        <form:form action="/license/create" method="POST" modelAttribute="license">
            <div class="form_input">
                <form:label path="expirationDate">Expiration Date</form:label>
                <form:errors path="expirationDate" class="text-danger" />
                <form:input path="expirationDate" />
            </div>
            <div class="form_input">
                <form:label path="state">State Abbreviation</form:label>
                <form:errors path="state" class="text-danger" />
                <form:input path="state" />
            </div>
            <form:select path="person">
                <c:forEach var="person" items="${allPeople}">
                    <form:option value="${person.id}">
                        <c:out value="${person.firstName}" /> <c:out value="${person.lastName}" />
                    </form:option>
                </c:forEach>
            </form:select>
            <button>Submit</button>
        </form:form>
    </div>

    <a href="/dashboard">Go Back</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>