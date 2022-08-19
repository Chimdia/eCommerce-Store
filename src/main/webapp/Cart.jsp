<%@ page import="model.Cart" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Dao.ProductsDao" %>
<%@ page import="Connections.DataBaseConnection" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  DecimalFormat dcf = new DecimalFormat("#.##");
  request.setAttribute("dcf", dcf);
  Users auth = (Users) request.getSession().getAttribute("auth");
  if (auth != null) {
    request.setAttribute("person", auth);
  }
  ArrayList<Cart> cartItems = (ArrayList<Cart>) session.getAttribute("cart-list");
  List<Cart> cartProduct = null;
  if (cartItems != null) {
    ProductsDao pDao = new ProductsDao(DataBaseConnection.getConnection());
    cartProduct = pDao.getCartProducts(cartItems);
    double total = pDao.getTotalCartPrice(cartItems);
    request.setAttribute("total", total);
    request.setAttribute("cartItems", cartItems);
  }
  %>

<!DOCTYPE html>
<html>
<head>
  <title>Cart</title>
  <%@include file="WEB-INF/Includes/head.jsp"%>
  <style type="text/css">
    .table tbody td{
      vertical-align: middle;
    }
    .btn-incre, .btn-decre{
      box-shadow: none;
      font-size: 25px;
    }
  </style>
</head>
<body>
<%@include file="WEB-INF/Includes/NavBar.jsp"%>
<div class="container my-3">
  <div class="d-flex py-3"><h3>Total Price:  ₦ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
  <table class="table table-light">
    <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Category</th>
      <th scope="col">Price</th>
      <th scope="col">Buy Now</th>
<%--      <th scope="col">Cancel</th>--%>
    </tr>
    </thead>
    <tbody>
    <%
      if (cartItems != null) {
        for (Cart c : cartProduct) {
    %>
    <tr>
      <td><%=c.getProductName()%></td>
      <td><%=c.getProductCategory()%></td>
      <td><%= dcf.format(c.getProductPrice())%></td>
      <td>
        <form action="CartServlet" method="post" class="form-inline">
          <input type="hidden" name="productId" value="<%= c.getProductId()%>" class="form-input">
          <div class="form-group d-flex justify-content-between">
            <a class="btn bnt-sm btn-incre" href="/DecIncServlet?action=inc&id=<%=c.getProductId()%>"><i class="fas fa-plus-square"></i></a>
            <input type="text" name="productQuantity" class="form-control"  value="<%=c.getProductQuantity()%>">
            <a class="btn btn-sm btn-decre" href="/DecIncServlet?action=dec&id=<%=c.getProductId()%>"><i class="fas fa-minus-square"></i></a>
          </div>
<%--          <button type="submit" class="btn btn-primary btn-sm">Buy</button>--%>
        </form>
      </td>
      <td><a href="RemoveFromCartServlet?id=<%=c.getProductId()%>" class="btn btn-sm btn-danger">Remove</a></td>
    </tr>

    <%
        }}%>
    </tbody>
  </table>
</div>

<%@include file="WEB-INF/Includes/footer.jsp"%>
</body>
</html>