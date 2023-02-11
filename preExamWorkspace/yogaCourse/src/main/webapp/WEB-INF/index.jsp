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
    <title>Project Manager</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Course Platform - Instructors</h1>
        <div class="container">
            <div class="register-form row">
                <form:form action="/register" method="POST" modelAttribute="newInstructor" class="col-sm">
                    <h2 class="form-subtitle">Register</h2>
                    <div class="form-input">
                        <form:label class="form-label" path="name" >Name</form:label>
                        <form:input  path="name" type="text"/>
                        <form:errors path="name" />
                    </div>
					<div class="form-input">
						<form:label class="form-label" path="email"> Email </form:label>
						<form:input path="email" type="email" />
						<form:errors path="email" />
					</div>
					<div class="form-input">
						<form:label class="form-label" path="password"> Password </form:label>
						<form:input path="password" type="password" />
						<form:errors path="password" />
					</div>
					<div class="form-input">
						<form:label class="form-label" path="confirmPassword"> Confirm Password </form:label>
						<form:input path="confirmPassword" type="password" />
						<form:errors path="confirmPassword" />
					</div>
					<button>Register!!</button>
                </form:form>
            </div>
            <div class="login-form row">
				<form:form action="/login" method="POST" modelAttribute="loginInstructor" class="col-sm">
					<h2 class="form-subtitle">Log in</h2>
					<div class="form-input">
						<form:label class="form-label" path="email"> Email </form:label>
						<form:input path="email" type="email" />
						<form:errors path="email" />
					</div>
					<div class="form-input">
						<form:label class="form-label" path="password"> Password </form:label>
						<form:input path="password" type="password" />
						<form:errors path="password" />
					</div>
					<button>Log In</button>					
				</form:form>

            </div>
        </div>

</body>
</html>