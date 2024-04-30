<%@ page import="uz.pdp.ecommerce.repo.CategoryRepo" %>
<%@ page import="uz.pdp.ecommerce.entity.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/1/2024
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body style="background: #0b4ad5">

<%
    List<Category> categories = CategoryRepo.findAll();
%>
<div class="row mt-4">
    <div class="col-3 offset-4">
        <div style="background: #47e312" class="card p-2">
            <h1 class="text-white">Edit User</h1>
            <form enctype="multipart/form-data" action="http://localhost:8080/product/add" method="post">
                <input name="name" class="form-control my-3" type="text" placeholder="Name">
                <input name="price" class="form-control my-3" type="number" placeholder="Price">
                <select name="categoryId" class="form-control">
                    <option value="" selected disabled>Select category</option>
                    <% for (Category category : categories) {%>
                    <option value="<%=category.getId()%>"><%=category.getName()%>
                    </option>
                    <%}%>
                </select>
                <label>
                    <img class="m-4 my-2" width="50"
                         src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWTJaSthXTSxa6Zhl2WoZaXsuYrK4Ldkdjc4VWRH1duulwDXPI5vtIulZaHfoABB6XDeM&usqp=CAU">mahsulotni
                    rasmini kiriting 🖼
                    <input name="photo" class="d-none" type="file">
                </label>
                <div class="text-center">
                    <button style="background: red" class="btn btn-dark btn-lg w-100">edit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
