<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book list</title>
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
    <form action="/book/delete" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Category</th>
                <th>Release Date</th>
                <th>Isbn</th>
                <th>Author</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group" role="group" aria-label="First group">
                    <a href="/book/add/form"><input type="button" class="btn btn-secondary" name="action" value="ADD"></a>
                    <input type="submit" class="btn btn-secondary" name="action" value="DELETE">
                    <!--<button type="button" class="btn btn-secondary">4</button> -->
                </div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text" id="btnGroupAddon2">@</div>
                    </div>
                    <input type="text" class="form-control" placeholder="Input group example"
                           aria-label="Input group example" aria-describedby="btnGroupAddon2">
                </div>
            </div>


            <c:forEach var="book" items="${books}" varStatus="loop">

                <c:url var="editLink" value="/author/edit/form">
                    <c:param name="bookEditId" value="${book.id}"/>
                </c:url>

                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${book.title}</td>
                    <td>${book.category}</td>
                    <td>${book.releaseDate}</td>
                    <td>${book.isbn}</td>
                    <td>${book.author.firstName} ${book.author.lastName}</td>
                    <td>${book.quantity}</td>
                    <td><input class="form-check-input" type="radio" name="bookId" value="${book.id}" checked></td>
                    <td>
                        <a href="${editLink}">Edit</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </form>
</div>
</body>
</html>
