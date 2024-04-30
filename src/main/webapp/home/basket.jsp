<%@ page import="uz.pdp.ecommerce.repo.BasketRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommerce.entity.BasketProduct" %>
<%@ page import="uz.pdp.ecommerce.entity.Product" %>
<%@ page import="uz.pdp.ecommerce.repo.BasketProductRepo" %>
<%@ page import="java.util.UUID" %>
<%@ page import="uz.pdp.ecommerce.services.AuthService" %>
<%@ page import="uz.pdp.ecommerce.entity.Basket" %>
<%@ page import="java.util.Base64" %>
<%@ page import="uz.pdp.ecommerce.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/1/2024
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body style="background: #0def20">
<%
    User currentUser = (User) session.getAttribute("currentUser");
%>
<div class="row">
    <div class="col-6 offset-3 my-5">
        <div class="p-4">
            <table class="table table-warning">
                <thead>
                <tr>
                    <th>Delete🚫</th>
                    <th>Name🔷</th>
                    <th>Photo📸</th>
                    <th>Price💲</th>
                    <th>#♻️#♻️#♻️#♻️#️</th>
                    <th>Sum📊</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Basket basket = BasketRepo.findBasket(AuthService.currentUser.getId());
                    assert basket != null;
                    List<BasketProduct> basketProducts1 = BasketProductRepo.findByBasket(basket.getId());
                    List<BasketProduct> basketProducts = BasketProductRepo.findAll();
                    int sum = 0;
                %>
                <%
                    for (BasketProduct basketProduct : basketProducts) {
                        Product product = Product.findProduct(basketProduct.getProductId());
                        assert product != null;
                        String base64 = Base64.getEncoder().encodeToString(product.getPhotoPath());
                %>
                <tr>
                    <td>
                        <a href="http://localhost:8080/remove/product?basketProductId=<%=basketProduct.getProductId()%>"
                           class="btn btn-danger">✖️</a>
                    </td>
                    <td>
                        <%= product.getName() %>
                    </td>
                    <td>
                        <img width="80" src="data:image/jpeg;base64,<%=base64%>">
                    </td>
                    <td>
                        <%= product.getPrice()%>
                    </td>
                    <td>
                        <a href="http://localhost:8080/product/count?id=<%=basketProduct.getId()%>&name=plus"
                           class="btn btn-info"
                           style="border-radius: 18px">➕</a>
                        <a class="btn btn-dark text-info"><%=basketProduct.getAmount()%>
                        </a>
                        <a href="http://localhost:8080/product/count?id=<%=basketProduct.getId()%>&name=minus"
                           class="btn btn-info" style="border-radius: 18px">➖</a>
                    </td>
                    <td>
                        <%= basketProduct.getAmount() * product.getPrice()%>💸
                    </td>
                    <%sum = sum + basketProduct.getAmount() * product.getPrice();%>
                </tr>
                <%}%>
                </tbody>
            </table>
            <div class="col-2 offset-2">
                <table class="btn btn-success" style="background: orangered">
                    <tr>
                        <td>
                            <a href="" class="btn btn-light">Total <%=sum%> (sum) 💵</a>
                        </td>
                        <%if (currentUser != null) {%>
                        <td>
                            <a href="http://localhost:8080/order/create?basketId=<%=basket.getId()%>"
                               class="btn btn-outline-dark text-dark m-2 text-white">Tasdiqlash </a>
                        </td>
                        <%} else { %>
                        <td>
                            <a href="../login.jsp"
                               class="btn btn-outline-dark text-dark m-2 text-white">Tasdiqlash </a>
                        </td>
                        <%}%>
                        <td>
                            <a href="http://localhost:8080/basket/clear?basketId=<%=basket.getId()%>"
                               class="btn btn-outline-dark text-dark m-2 text-white">
                                Buyurtmalarni bekor qilish </a>
                        </td>
                        <td>
                            <a href="../index.jsp" class="btn btn-outline-dark text-dark text-white">back 🔙</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>
