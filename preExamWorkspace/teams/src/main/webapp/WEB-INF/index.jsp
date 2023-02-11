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
		<link rel="stylesheet" href="/css/style.css">  <!-- change to match your file/naming structure -->

        <title>Teams</title>
    </head>
    <body>

        <h1>Welcome to Teams!</h1>
        
        
        <table>
        	<thead>
        		<tr>
        			<th>#</th>
        			<th>City</th>
        			<th>Name</th>
        			<th>Established</th>
					<th>Actions</th>
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach var="team" items="${allTeams}">
        			<tr>
        				<td><c:out value="${team.id}" /></td>
        				<td><a href="/teams/${team.id}"><c:out value="${team.city}" /></a></td>
        				<td><a href="/teams/${team.id}"><c:out value="${team.name}" /></a></td>
        				<td><c:out value="${team.createdAt}" /></td>
						<td>
							<a href="/teams/${team.id}/edit">Edit</a>
							<form:form action="/teams/${team.id}/delete" method="DELETE" modelAttribute="team">
								<button>Delete</button>
							</form:form>
						</td>
        			</tr>
        		</c:forEach>
        	</tbody>
        </table>

		<a href="/teams/new">Create a new Team</a>
		<a href="/coaches/new">Create a new Coach</a>
		<a href="/players/new">Create a new Player</a>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>