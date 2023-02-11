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
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->

    <title>Dashboard</title>
</head>
<body>
    <h1>Create a Person or a License</h1>
    
    <a href="/person/new">New Person</a>
    <a href="/licenses/new">New License</a>

    <h2>Person Details:</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>License Number</th>
                <th>State</th>
                <th>Exp Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="person" items="${allPeople}">
                <tr>
                    <td><c:out value="${person.lastName}" />,<c:out value="${person.firstName}" /></td>
                    <td><c:out value="${person.license.number}" /></td>
                    <td><c:out value="${person.license.expirationDate}" /></td>
                    <td><c:out value="${person.license.state}" /></td>
                    <td>
                        <form action="/person/${person.id}/delete" method="post">
                        <input type="hidden" name="_method" value="delete" />
                        <button>Delete</button>
                </form>
                    </td>
                </tr>

            </c:forEach>
        </tbody>
    </table>


    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>