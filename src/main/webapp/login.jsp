<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/11/2024
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body style="background: #80bdff">
<div class="row pt-4">
    <div class="col-4 offset-4">
        <div class="card">
            <div class="card-header bg-dark text-white">
                Login
            </div>
            <div class="card-body p-2">
                <form action="../auth/login" method="post">
                    <div>
                        <input class="form-control" name="username" type="text" placeholder="UserName">
                    </div>
                    <div>
                        <input class="form-control my-2" name="password" type="password" placeholder="Password">
                    </div>
                    <button class="btn btn-dark btn-lg w-100">sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
