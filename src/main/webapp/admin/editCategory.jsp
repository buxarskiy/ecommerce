<%@ page import="java.util.UUID" %>
<%@ page import="uz.pdp.ecommerce.repo.CategoryRepo" %>
<%@ page import="uz.pdp.ecommerce.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2024
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<%
    UUID id = UUID.fromString(request.getParameter("id"));
    Category category = CategoryRepo.findById(id);
%>

<div class="row mt-4">
    <div class="col-3 offset-4">
        <div class="card p-2">
            <h1>Edit category</h1>
            <form action="http://localhost:8080/category/edit" method="post">
                <input name="id" type="hidden" value="<%= category.getId()%>">
                <input name="name" type="text" value="<%=category.getName()%>" placeholder="Name">
                <button class="btn-dark">edit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
