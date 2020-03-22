<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add book</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="/book/add" method="post">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="bookTitle">Title</label>
                    <input type="text" class="form-control" required="true" id="bookTitle" name="title" value="${book.title}">
                </div>
                <div class="form-group">
                    <label for="bookIsbn">ISBN</label>
                    <input type="text" class="form-control" required="true" id="bookIsbn" name="isbn" value="${book.isbn}">
                </div>

                <div class="form-group">
                    <label for="bookQuantity">Quantity</label>
                    <input type="number" class="form-control" required="true" id="bookQuantity"  name="quantity" value="${book.quantity}">
                </div>
            </div>

            <div class="col-sm-6">
                <div class="form-group">
                    <label for="bookCategory">Category</label>
                    <select class="form-control" id="bookCategory" name="category">
                        <c:forEach var="category" items="${categories}">
                            <option>${category}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="author">Author</label>
                    <select class="form-control" id="author" name="authorId">
                        <c:forEach var="author" items="${authors}">
                            <option value="${author.id}">${author.firstName} ${author.lastName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="bookRelease">Release</label>
                    <input type="date" class="form-control" required="true" id="bookRelease" name="release" value="${book.release}">
                </div>
            </div>

        </div>
        <input type="submit" value="Add" class="btn btn-success">
        <a href="/book/list">
            <button type="button" class="btn btn-outline-secondary">Cancel</button>
        </a>
    </form>
</div>
</body>
</html>
