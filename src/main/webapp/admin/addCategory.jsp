<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2024
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<div class="row mt-4">
    <div class="col-3 offset-4">
        <div class="card p-2">
            <h1>Add category</h1>
            <form action="http://localhost:8080/category/add" method="post">
                <input name="name" type="text" placeholder="Name">
                <button class="btn-dark">save</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
