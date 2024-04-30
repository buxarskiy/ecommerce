<%@ page import="uz.pdp.ecommerce.repo.CategoryRepo" %>
<%@ page import="uz.pdp.ecommerce.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommerce.entity.Product" %>
<%@ page import="uz.pdp.ecommerce.repo.ProductRepo" %>
<%@ page import="java.util.UUID" %>
<%@ page import="uz.pdp.ecommerce.repo.BasketRepo" %>
<%@ page import="uz.pdp.ecommerce.entity.Basket" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/1/2024
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<%--
<%
    List<Category> categories = CategoryRepo.findAll();
    UUID categoryId = UUID.fromString(request.getParameter("categoryId"));
    List<Product> products = ProductRepo.productByCategory(categoryId);

%>
<nav class="navbar bg-body-tertiary bg-dark">
    <div class="container-fluid btn btn-success text-white">
        <a class="navbar-brand" href="#">Market🛍</a>
        <a class="btn btn-outline-dark text-white" href="../home/izox.jsp">Izox qoldirish📩</a>
        <a class="btn btn-outline-warning text-white" href="../home/basket.jsp">Basket🛒</a>
    </div>
</nav>
<div class="row">
    <div class="col-2 border-right p-4">
        <ul class="list-group">
            <h1>Category</h1>
            <li class="list-group-item">
                <%
                    for (Category category : categories) {
                %>
                <p><a class="btn btn-success text-white"
                      href="../home/productByCategory.jsp?categoryId=<%=category.getId()%>">
                    <%= category.getName()%>
                </a></p>
                <%}%>
            </li>
        </ul>
    </div>
    <div class="col-9">
        <div class="p-4">
            <table class="table table-success">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>#</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Product product : products) {
                        if (product.getCategoryId().equals(categoryId)) {
                %>
                <tr>
                    <td>
                        <%= product.getName()%>
                    </td>
                    <td>
                        <%= product.getPrice()%>
                    </td>
                    <td>
                        <a href="http://localhost:8080/add/basket?productId=<%=product.getId()%>&categoryId=<%=categoryId%>"
                           class="btn btn-outline-success">Savatga</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
--%>
</body>
</html>
