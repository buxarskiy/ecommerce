<%@ page import="uz.pdp.ecommerce.entity.Order" %>
<%@ page import="uz.pdp.ecommerce.entity.OrderProduct" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommerce.repo.OrderProductRepo" %>
<%@ page import="uz.pdp.ecommerce.repo.OrderRepo" %>
<%@ page import="uz.pdp.ecommerce.repo.ProductRepo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/13/2024
  Time: 1:30 AM
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
    int orderId = Integer.parseInt(request.getParameter("orderId"));
//    Order order = OrderRepo.find(orderId);
    List<OrderProduct> orderProducts = OrderProductRepo.findByOrder(orderId);
%>
<div>
    <hr>
    <div>
        <table class="table table-success mx-2">
            <thead>
            <tr>
                <th>Order_id</th>
                <th>Product_id</th>
                <th>Count</th>
            </tr>
            </thead>
            <tbody>
            <%for (OrderProduct orderProduct : orderProducts) {%>
            <tr>
                <td><%=orderProduct.getOrderId()%>
                </td>
                <td><%=ProductRepo.findById(orderProduct.getProductId()).getName()%>
                </td>
                <td><%=orderProduct.getAmount()%>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
