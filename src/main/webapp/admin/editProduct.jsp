<%@ page import="java.util.UUID" %>
<%@ page import="uz.pdp.ecommerce.entity.Product" %>
<%@ page import="uz.pdp.ecommerce.repo.ProductRepo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/1/2024
  Time: 11:10 AM
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
    Product product = ProductRepo.findById(id);

%>
<div class="row mt-4">
    <div class="col-3 offset-4">
        <div class="card p -2">
            <h1>Edit product</h1>
            <form action="http://localhost:8080/product/edit" method="post">
                <input name="id" type="hidden" value="<%=product.getId()%>">
                <input name="price" type="number" value="<%=product.getPrice()%>">
                <input class="mt-4" name="name" type="text" value="<%=product.getName()%>" placeholder="Name">
                <button class="btn-dark">edit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
