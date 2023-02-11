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
    <title>Create a Course</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class=editCourse>
		<form:form action="/classes/${course.id}/update" method='POST' modelAttribute="course" >
		    <div>
				<form:label path="name"> Name </form:label>
				<form:input path="name" type="name" />
				<form:errors path="name" />
			</div>
			<div>
                <form:select path="weekday">
                    <form:option value="mon">MON</form:option>
                    <form:option value="tues">TUES</form:option>
                    <form:option value="wed">WED</form:option>
                    <form:option value="thur">THUR</form:option>
                    <form:option value="fri">FRI</form:option>
                    <form:option value="sat">SAT</form:option>
                    <form:option value="sun">SUN</form:option>
                </form:select>
			</div>
			<div>
				<form:label path="price"> Drop-in Price </form:label>
				<form:input path="price" type="number" />
				<form:errors path="price" />
			</div>
			<div>
				<form:label path="time"> Drop-in time </form:label>
				<form:input path="time" type="time"/>
				<form:errors path="time" />
			</div>
			<div>
				<form:label path="description"> Description </form:label>
				<form:input path="description" type="text"/>
				<form:errors path="description" />
			</div>
            <div>
                <form:input type="hidden" path="instructor" value="${instructor.id}}"></form:input>
            </div>
            <div>
                <button><a href="/dashboard">Cancel</a></button>
            </div>
		    <button>Submit</button>
		</form:form>
        <form:form action="/classes/${course.id}/delete" method="DELETE" modelAttribute="course">
        <button>Delete</button>
        </form:form>

	</div>