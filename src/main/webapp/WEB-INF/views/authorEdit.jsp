<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit author</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="/author/edit" method="post">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group" hidden>
                    <label for="authorIdToEdit">Id</label>
                    <input type="text" class="form-control" id="authorIdToEdit" name="authorIdToEdit" value="${authorToEdit.id}">
                </div>
                <div class="form-group">
                    <label for="authorFirstName">First name</label>
                    <input type="text" class="form-control" required="true" id="authorFirstName" name="firstName" value="${authorToEdit.firstName}">
                </div>
                <div class="form-group">
                    <label for="authorLastName">Last name</label>
                    <input type="text" class="form-control" required="true" id="authorLastName" name="lastName" value="${authorToEdit.lastName}">
                </div>
            </div>
        </div>
        <input type="submit" value="Save" class="btn btn-success">
        <a href="/author/list">
            <button type="button" class="btn btn-outline-secondary">Cancel</button>
        </a>
    </form>
</div>
</body>
</html>
