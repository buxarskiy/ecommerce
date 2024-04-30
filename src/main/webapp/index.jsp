<%@ page import="uz.pdp.ecommerce.entity.Category" %>
<%@ page import="uz.pdp.ecommerce.repo.CategoryRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommerce.entity.Product" %>
<%@ page import="java.util.UUID" %>
<%@ page import="uz.pdp.ecommerce.repo.ProductRepo" %>
<%@ page import="uz.pdp.ecommerce.repo.BasketProductRepo" %>
<%@ page import="uz.pdp.ecommerce.entity.BasketProduct" %>
<%@ page import="java.util.Base64" %>
<%@ page import="uz.pdp.ecommerce.entity.User" %>
<%@ page import="uz.pdp.ecommerce.enums.Role" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Market🛍</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body style="background: #e30f68">
<%
    User currentUser = (User) session.getAttribute("currentUser");
    List<BasketProduct> basketProducts = BasketProductRepo.findAll();
    List<Category> categories = CategoryRepo.findAll();
    List<Product> products;
    String parameter = request.getParameter("categoryId");
    if (parameter != null) {
        UUID categoryId = UUID.fromString(parameter);
        products = ProductRepo.productByCategory(categoryId);
    } else {
        products = ProductRepo.findAll();
    }
%>
<nav class="navbar bg-body-tertiary bg-dark">
    <div style="background: #23ef14" class="container-fluid btn btn-success text-white">
        <a class="navbar-brand" href="#">Market🛍</a>
        <%if (currentUser == null) {%>
        <%if (!basketProducts.isEmpty()) {%>
        <a class="btn btn-outline-warning text-black" href="home/basket.jsp">Basket🛒<%=basketProducts.size()%>
        </a>
        <%} else {%>
        <a class="btn btn-outline-warning text-black">Basket🛒
        </a>
        <%}%>
        <a class="btn btn-outline-warning text-black" href="home/izox.jsp">Izox qoldirish📩</a>
        <a class="btn btn-outline-danger text-black" href="login.jsp">login</a>
        <% } else {
            if (currentUser.getRole().equals(Role.ADMIN)) {%>
        <a class="btn btn-outline-danger text-black" href="admin/admin.jsp">Admin👨‍💻</a>
        <button>
            <img class="rounded" width="35" src="<%=currentUser.getPhoto()%>" alt="">
            <%=currentUser.getUserName()%>
            <a class="btn btn-dark text-black text-white"
               href="http://localhost:8080/login/logout?userId=<%=currentUser.getId()%>">logout</a>
        </button>
        <%} else {%>
        <%if (!basketProducts.isEmpty()) {%>
        <a class="btn btn-outline-warning text-black" href="home/basket.jsp">Basket🛒<%=basketProducts.size()%>
        </a>
        <%} else {%>
        <a class="btn btn-outline-warning text-black">Basket🛒
        </a>
        <%}%>
        <a class="btn btn-outline-warning text-black" href="home/myOrders.jsp">My orders📊</a>
        <a class="btn btn-outline-warning text-black" href="home/izox.jsp">Izox qoldirish📩</a>
        <button>
            <img class="rounded" width="35" src="<%=currentUser.getPhoto()%>" alt="">
            <%=currentUser.getUserName()%>
            <a class="btn btn-dark text-black text-white"
               href="http://localhost:8080/login/logout">logout</a>
        </button>
        <%}%>
        <%}%>
    </div>
</nav>
<div class="row">
    <div class="col-2 border-right p-4">
        <ul class="list-group">
            <h1>Category</h1>
            <li class="list-group-item">
                <p><a href="?" class="btn btn-success text-white">Barcha mahsulotlar</a></p>
                <%
                    for
                    (
                            Category
                                    category
                            :
                            categories
                    ) {
                %>
                <p><a class="btn btn-success text-white"
                      href="?categoryId=<%=category.getId()%>">
                    <%= category
                            .
                            getName
                                    (
                                    )%>
                </a></p>
                <%}%>
            </li>
        </ul>
    </div>
    <div class="col-9">
        <div class="row">
            <%
                for
                (
                        Product
                                product
                        :
                        products
                ) {
                    String
                            base64
                            =
                            Base64
                                    .
                                    getEncoder
                                            (
                                            )
                                            .
                                    encodeToString
                                            (
                                                    product
                                                            .
                                                            getPhotoPath
                                                                    (
                                                                    )
                                            );
            %>
            <div class="col-3">
                <div style="background: #1ccfe7" class="card p-3 my-3 btn-dark">
                    <img width="230" height="200"
                         src="data:image/jpeg;base64,<%=base64%>">
                    <h4><%= product

                            .
                            getName
                                    (
                                    )%>
                    </h4>
                    <h4><%= product
                            .
                            getPrice
                                    (
                                    )%>💸
                    </h4>
                    <%
                        if
                        (
                                BasketProductRepo.findByProductId(product.getId()).isEmpty()
                        ) {
                    %>
                    <form action="../add/basket" method="post">
                        <input type="hidden" name="productId" value="<%=product.getId()%>">
                        <button class="btn btn-dark btn-lg w-100"> Savatga🧺</button>
                    </form>
                    <%
                    } else {
                    %>
                    <form action="../delete/basketProduct" method="post">
                        <input type="hidden" name="productId" value="<%=product.getId()%>">
                        <button class="btn btn-dark btn-lg w-100">Savatdan o'chirish❌</button>
                    </form>
                    <%} %>
                </div>
            </div>
            <%} %>
        </div>
    </div>
</div>
</body>
</html>