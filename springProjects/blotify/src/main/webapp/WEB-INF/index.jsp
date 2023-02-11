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

		<title>Blotify</title>
	</head>
	<body>
		<div class="container">
			<h1>Welcome to Blotify.</h1>
			<div class="row">
				<form:form action="/register" method="POST" modelAttribute="newUser" class="col-sm">
					<h2>Register for Blotify!</h2>
					<div>
						<form:label path="username"> Username </form:label>
						<form:input path="username" type="text" />
						<form:errors path="username" />
					</div>
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
					<div>
						<form:label path="confirmPass"> ConfirmPass </form:label>
						<form:input path="confirmPass" type="password" />
						<form:errors path="confirmPass" />
					</div>
					<button>Register!!</button>
				</form:form>
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