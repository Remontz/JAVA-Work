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

	<title>Edit Listing</title>
</head>
<body>
	<h1>Edit Listing </h1>
    <a href="/">Dashboard</a>
	
	<div class=editListing>
		<form:form action="/listing/${listing.id}/update" method='POST' modelAttribute="listing" >
		    <div>
				<form:label class="form-label" path="address"> Address: </form:label>
				<form:input path="address" type="address" />
				<form:errors path="address" />
			</div>
			<div>
				<form:label class="form-label" path="price"> Price: </form:label>
				<form:input path="price" type="number" />
				<form:errors path="price" />
			</div>
			<div>
				<form:label class="form-label" path="updatedAt"> Listing Date: </form:label>
				<form:input path="updatedAt" type="number" />
				<form:errors path="updatedAt" />
			</div>
		    <button>Submit</button>
		</form:form>
	</div>
    <form:form action="/listing/${listing.id}/delete" method="DELETE" modelAttribute="listing">
        <button>Delete</button>
    </form:form>
	
	<script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>