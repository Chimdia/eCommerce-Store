<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 13/08/2022
  Time: 08:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <%@include file="WEB-INF/Includes/head.jsp"%>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="Products.jsp"><h1>Products</h1></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="Products.jsp">Products</a></li>
                <li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<a class="nav-link" href="Admin Dashboard.jsp"><span>Back</span></a>
</body>
</html>
