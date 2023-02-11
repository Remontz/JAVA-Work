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

        <title>View Team</title>
    </head>
    <body>
        <h1>Welcome to <c:out value="${team.city}" /> <c:out value="${team.name}"/>'s Roster Page!</h1>
        <a href="/teams/${team.id}/edit">Edit Team</a>

        
        <div class="CoachesTable">
            <h4><c:out value="${team.city}" />'s Coaches</h4>
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Coaching Since</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="coaches" items="${team.coaches}">
                        <tr>
                            <td><c:out value="${coaches.id}" /></td>
                            <td>Coach <c:out value="${coaches.firstName}" /> <c:out value="${coaches.lastName}" /></td>
                            <td><c:out value="${coaches.role}" /></td>
                            <td><c:out value="${coaches.createdAt}" /></td>
                            <td>
                                <a href="/coaches/${coaches.id}">View</a>
                                <a href="/coaches/${coaches.id}/edit">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="PlayersTable">
            <h4>The <c:out value="${team.name}" />'s!!!!</h4>
            <table>
                <thead>
                    <tr>
                        <th>No. ##</th>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Age</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="players" items="${team.players}">
                        <tr>
                            <td><c:out value="${players.jerseyNum}" /></td>
                            <td><c:out value="${players.lastName}" />, <c:out value="${players.firstName}" /></td>
                            <td><c:out value="${players.position}" /></td>
                            <td><c:out value="${players.age}" /></td>
                            <td>
                                <a href="/players/${players.id}">View</a>
                                <a href="/players/${players.id}/edit">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a href="/">Go Back</a>
        <a href="/coaches/new">Create a new Coach</a>
        <a href="/players/new">Create a new Player</a>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>