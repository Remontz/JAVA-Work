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
    
    <title>Lookify!</title>
</head>
<body>
    <h1>Welcome to Lookify!</h1>
    <h2>Dashboard</h2>

    <a href="/songs/new">Add New</a>
    <a href="/search/topTen">See Top Ten Rated</a>

    <form action="/search" method="post" >
        <input type="text" name="search" />
        <button>Search Artists</button>
    </form>
    <p><c:out value="${error}" /></p>

    <table class="table-secondary, table-striped">
        <thead>
            <tr>
                <th scope="col">Artist</th>
                <th scope="col">Title</th>
                <th scope="col">Rating</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="song" items="${songs}">
                <tr>
                    <td scope="row"><c:out value="${song.artist}" /></td>
                    <td>
                        <a href="/songs/${song.id}">
                            <c:out value="${song.title}" />
                        </a>
                    </td>
                    <td><c:out value="${song.rating}" /></td>
                    <td><a href="/songs/${song.id}/delete">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>