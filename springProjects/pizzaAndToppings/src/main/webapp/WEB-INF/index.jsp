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
<title>Pizza & Toppings!</title>
</head>
<body>
    <h1>Welcome to Pizza Dojo!</h1>
    <div class="main">
        <div class="pizza">
            <h2>Our pizzas!</h2>
            <ul>
                <!--c:forEach to list all pizza objects as links-->
                <c:forEach var="pizza" items="${allPizzas}">
                    <li>
                        <c:out value="${pizza.name}" />
                    </li>
                </c:forEach>
            </ul>
            <p> 
                <a href="/pizza/create"> Click Here  to create a new pizza </a>
            </p>
        </div>

        <div class="topping">
            <h2>Our toppings!</h2>
            <ul>
                <!--c:forEach to list all topping objects as links-->
                <c:forEach var="topping" items="${allToppings}">
                    <li>
                        <c:out value="${topping.name}" />
                    </li>
                </c:forEach>
            </ul>
            <p> 
                <a href="/topping/create"> Click Here  to create a new topping </a> 
            </p>
        </div>
    </div>
</body>
</html>