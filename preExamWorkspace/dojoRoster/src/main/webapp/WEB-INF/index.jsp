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

<title>Dashboard</title>
</head>
<body>
    <h1>Create a Ninja or a Dojo</h1>

    <a href="/dojo/new">New Dojo</a>
    <a href="/ninja/new">New Ninja</a>

    <h2>Dojos</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <!-- <th>Ninjas</th> -->
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dojo" items="${allDojos}">
                <tr>
                    <td><a href="/dojo/${dojo.id}"><c:out value="${dojo.name}"  /></a></td>
                    <td>                        
                        <form action="/dojo/${dojo.id}/delete" method="post">
                            <input type="hidden" name="_method" value="delete" />
                            <button>Delete Dojo</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Ninja Details</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${allNinjas}" >
                <tr>
                    <td><c:out value="${ninja.id}" /></td>
                    <td><c:out value="${ninja.firstName}" />  <c:out value="${ninja.lastName}" /> </td>
                    <td>
                        <form action="/ninja/{$ninja.id}/delete" method="post">
                            <input type="hidden" name="_method" value="delete" />
                            <button>Delete Ninja</button>
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