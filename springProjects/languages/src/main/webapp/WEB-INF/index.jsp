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
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    
    <title>Languages</title>
</head>
<body>
    <h1> Languages </h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="language" items="${languages}">
                <tr>
				    <td class="text-center"><a href="/languages/show/${language.id}"><c:out value="${language.name}"></c:out></a></td>
				    <td class="text-center"><c:out value="${language.creator}"></c:out></td>
				    <td class="text-center"><c:out value="${language.version}"></c:out></td>
				    <td class="text-center"><a href="/languages/edit/${language.id}">edit</a></td>
				    <td class="text-center">
                        <form action="/languages/delete/${language.id}" method = "post">
                            <input type="hidden" name="_method" value="delete" />
                            <input type="submit" value="Delete" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <form:form action="/languages/create" method="post" modelAttribute="language">
        <div>
            <form:label path="name">Language Name: </form:label>
            <form:errors path="name" class="text-danger" />
            <form:input type="text" path="name" />
        </div>
        <div>
            <form:label path="creator">Creator: </form:label>
            <form:errors path="creator" class="text-danger" />
            <form:input type="text" path="creator" />
        </div>
        <div>
            <form:label path="version">Version: </form:label>
            <form:errors path="version" class="text-danger" />
            <form:input type="text" path="version" />
        </div>
        <button>Submit!</button>
    </form:form>

	<script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>