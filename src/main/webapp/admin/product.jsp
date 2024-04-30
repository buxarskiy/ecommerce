<%@ page import="uz.pdp.ecommerce.repo.ProductRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommerce.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2024
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body style="background: maroon">

<% List<Product> products = ProductRepo.findAll();%>

<div class="row">
    <div class="col-2 border-right p-4">
        <ul class="list-group">
            <a href="category.jsp">
                <li class="list-group-item"> Category</li>
            </a>
            <a href="product.jsp">
                <li class="list-group-item bg-dark text-white"> Product</li>
            </a>
            <a href="../index.jsp">
                <li class="list-group-item"> Home</li>
            </a>
        </ul>
    </div>
    <div class="col-9">
        <div class="row">
            <div class="col-2 offset-11 p-3">
                <a href="addProduct.jsp" class="btn btn-dark text-white"> Add product</a>
            </div>
        </div>
        <hr>
        <div class="p-4">
            <table class="table table-success">
                <thead>
                <tr>
                    <th>Category</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>#</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Product product : products) {%>
                <tr>
                    <td>
                        <%= product.getCategoryName()%>
                    </td>
                    <td>
                        <%= product.getName()%>
                    </td>
                    <td>
                        <%= product.getPrice()%>
                    </td>
                    <td>
                        <a href="editProduct.jsp?id=<%= product.getId()%>" class="btn btn-info text-white"> edit</a>
                        <a href="http://localhost:8080/product/delete?id=<%=product.getId()%>"
                           class="btn btn-dark text-white"> delete</a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
