<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>ADMIN PAGE</title>
  <%@include file="WEB-INF/Includes/head.jsp"%>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="Admin Dashboard.jsp"><h1>Admin Dashboard</h1></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="Products.jsp">Products</a></li>
        <li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%@include file="WEB-INF/Includes/footer.jsp"%>
</body>
</html>