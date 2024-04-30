<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/1/2024
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">

</head>
<body style="background: #e80a6e">
<div class="row">
    <div class="col-4 border-right p-4">
        <ul class="list-group">
            <p>
                <label>
                    Ism:
                    <input type="text" placeholder="Ism kiriting...">
                </label>
            </p>
            <p>
                <label>
                    Email:
                    <input type="email" placeholder="Emailni kiriting...">
                </label>
            </p>
            <p>
                <label>
                    Izoh:
                    <textarea cols="10" rows="10" placeholder="Izoh yozing..."></textarea>
                </label>
            </p>
            <a href="../index.jsp">
                <li class="btn btn-dark text-white">Yuborish</li>
            </a>


        </ul>
    </div>
</div>
</body>
</html>
