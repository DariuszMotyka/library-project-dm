<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Author list</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-2/css/bootstrap.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<div class="container mt-4">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Menu:</th>
            <th><a href="/author/list">Authors</a></th>
            <th><a href="/book/list">Books</a></th>
            <th><a href="/rental/list">Renting</a></th>
            <th><a href="/settings/list">Settings</a></th>
            <th><a>Logout</a></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <h1>Welcome in Your library</h1>
        </tr>
        </tbody>
    </table>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>First name</th>
            <th>Last name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="author" items="${authors}" varStatus="loop">
            <tr>
                <th scope="row">${loop.index + 1}</th>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
