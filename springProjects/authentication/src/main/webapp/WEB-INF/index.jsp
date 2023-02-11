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

        <title>Login & Registration</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        <h5>Join our growing community</h5>
        <div class="container">
            <div class="register-form row">
                <form:form action="/register" method="POST" modelAttribute="newUser" class="col-sm">
                    <h3>Register</h3>
                    <div>
                        <form:label path="username" >Username</form:label>
                        <form:input  path="username" type="text"/>
                        <form:errors path="username" />
                    </div>
					<div>
						<form:label path="email"> Email </form:label>
						<form:input path="email" type="email" />
						<form:errors path="email" />
					</div>
					<div>
						<form:label path="password"> Password </form:label>
						<form:input path="password" type="password" />
						<form:errors path="password" />
					</div>
					<div>
						<form:label path="confirm"> Confirm Password </form:label>
						<form:input path="confirm" type="password" />
						<form:errors path="confirm" />
					</div>
					<button>Register!!</button>
                </form:form>
            </div>
            <div class="login-form row">
				<form:form action="/login" method="POST" modelAttribute="loginUser" class="col-sm">
					<h2>Log In Here</h2>
					<div>
						<form:label path="email"> Email </form:label>
						<form:input path="email" />
						<form:errors path="email" />
					</div>
					<div>
						<form:label path="password"> Password </form:label>
						<form:input path="password" type="password" />
						<form:errors path="password" />
					</div>
					<button>Log In</button>					
				</form:form>

            </div>
        </div>



    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>