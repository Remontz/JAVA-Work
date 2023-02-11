<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="UTF-8" />
			<!-- for Bootstrap CSS -->
			<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
			<!-- local CSS -->
			<link rel="stylesheet" type="text/css" href="/css/style.css">

			<title>Fruit Store</title>
		</head>
		<body>
			<h1>Fruit Store</h1>
			
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${fruits}">
						<tr>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.price}"></c:out></td>
						</tr>
					</c:forEach>		
				</tbody>
			</table>
			
		
		
		
		
					<!-- For any Bootstrap that uses JS or jQuery -->
			<script src="/webjars/jquery/jquery.min.js"></script>
			<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		</body>
	</html>