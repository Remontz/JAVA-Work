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
    <title>Project Manager Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1><c:out value="${instructor.name}" /></h1>
    <a href="/logout">logout</a>

    <h6>Course Schedule</h6>

    <table>
        <thead>
            <tr>
                <th>Class Name</th>
                <th>Instructor</th>
                <th>Weekday</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${allClasses}">
                <tr>
                    <td>
                        <a href="/classes/${course.id}"><c:out value="${course.name}" /></a>
                        <c:if test="${course.instructor.id == instructor.id}">
                            <a href="/classes/${course.id}/edit">edit</a>
                        </c:if>

                    </td>
                    <td><c:out value="${course.instructor.name}" /></td>
                    <td><c:out value="${course.weekday}" /></td>
                    <td><c:out value="${course.price}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="/classes/new">+ new course</a>



</body>
</html>