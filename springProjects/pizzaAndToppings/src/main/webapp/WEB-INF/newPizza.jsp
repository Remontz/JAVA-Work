<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
    <meta charset="ISO-8859-1" />
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <title>New Pizza</title>
  </head>
  <body>
    <form:form action="/pizza/create" method="post" modelAttribute="pizza">
        <h2>Please Name your Pizza!</h2>
        <div>
            <form:label path="name">Name</form:label>
            <form:input  path="name" />
            <form:errors path="name" class="text-danger" />
        </div>
        <button>Create!</button>
    </form:form>

    <p>
        <a href="/">Click Here</a>to return to the Dashboard.
    </p>
  </body>
</html>
