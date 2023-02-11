<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="UTF-8" />
			<!-- for Bootstrap CSS -->
			<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
			<!-- local CSS -->
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<!-- For any Bootstrap that uses JS or jQuery -->
			<script src="/webjars/jquery/jquery.min.js"></script>
			<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
			<title>Hoppers Receipt</title>
			
		</head>
		<body>
			<h1>Customer Name: <c:out value="${customerName}"></c:out></h1>
			<div class="card">
  				<div class="card-header">Receipt</div>
  				<div class="card-body">
    				<h5 class="card-title">Details of purchase</h5>
					<p>Item Name: <c:out value="${itemName}"></c:out></p>
					<p>Price: <c:out value="${price}"></c:out></p>
					<p>Description: <c:out value="${description}"></c:out></p>
					<p>Vendor: <c:out value="${vendor}"></c:out></p>
  				</div>
  				<div class="card-footer text-muted">2 days ago</div>
			</div>

		
			<script type="text/javascript" src="js/app.js"></script>
		</body>
		
	</html>