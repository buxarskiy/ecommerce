<%@ page import="uz.pdp.ecommerce.entity.Order" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="uz.pdp.ecommerce.services.AuthService" %>
<%@ page import="uz.pdp.ecommerce.repo.OrderRepo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/13/2024
  Time: 1:00 AM
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
    List<Order> orders = OrderRepo.findAll(AuthService.currentUser.getId());
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
%>

<div class="row">
    <div class="col-9">
        <hr>
        <div class="p-4">
            <h1>Your product list</h1>
            <table class="table table-striped">
                <thead>
                <tr>

                    <th>Id</th>
                    <th>Time</th>
                    <th>Product</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Order order : orders) {
                        LocalDateTime localDateTime = order.getDateTime().toLocalDateTime();
                %>
                <tr>
                    <td><%=order.getId()%>
                    </td>
                    <td><%=localDateTime.format(dateTimeFormatter)%>
                    </td>
                    <td>
                        <a class="btn btn-success" style="border-radius: 10px"
                           href="../home/orderProductsShow.jsp?orderId=<%=order.getId()%>">Details</a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <hr>
        </div>
    </div>
    <a class="btn btn-primary" href="../index.jsp">back to Menu</a>
</div>

</body>
</html>
