<%@ page import="Connections.DataBaseConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.Dao.ProductsDao" %>
<%@ page import="model.Products" %>
<%@ page import="model.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Users" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--<%--%>
<%--    User auth = (User) request.getSession().getAttribute("auth");--%>
<%--    if (auth != null) {--%>
<%--        request.setAttribute("person", auth);--%>
<%--    }--%>
<%--    ProductsDao pd = new ProductsDao(DataBaseConnection.getConnection());--%>
<%--    List<Products> products = pd.getAllProducts();--%>
<%--    ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");--%>
<%--    if (cartList != null) {--%>
<%--        request.setAttribute("cart_list", cartList);--%>
<%--    }--%>
<%--%>--%>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>DIPSON STORES</title>--%>
<%--    <%@include file="WEB-INF/Includes/head.jsp"%>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@include file="WEB-INF/Includes/NavBar.jsp"%>--%>


<%--<div class="container">--%>
<%--    <div class="card-header my-3">Shoes just for you!!</div>--%>
<%--    <div class="row">--%>
<%--        <%--%>
<%--            if (!products.isEmpty()) {--%>
<%--                for (Products p : products) {--%>
<%--        %>--%>
<%--        <div class="col-md-3 my-3">--%>
<%--            <div class="card w-100">--%>
<%--                <img class="card-img-top" src="Products/boots.jpeg"--%>
<%--                     alt="Card image cap">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">Balenciaga Soft Boots</h5>--%>
<%--                    <h6 class="price">Price:₦30,000.00</h6>--%>
<%--                    <h6 class="category">Category: Boots</h6>--%>
<%--                    <div class="mt-3 d-flex justify-content-between">--%>
<%--                        <a class="btn btn-success" >Add to Cart</a> <a--%>
<%--                            class="btn btn-primary">Buy Now</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div><div class="card w-100">--%>
<%--            <img class="card-img-top" src="Products/Sandals.webp"--%>
<%--                 alt="Card image cap">--%>
<%--            <div class="card-body">--%>
<%--                <h5 class="card-title">Dipson Handmade sandal</h5>--%>
<%--                <h6 class="price">Price:₦15,000.00</h6>--%>
<%--                <h6 class="category">Category: Sandals</h6>--%>
<%--                <div class="mt-3 d-flex justify-content-between">--%>
<%--                    <a class="btn btn-success" >Add to Cart</a>--%>
<%--                    <a class="btn btn-primary">Buy Now</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div><div class="card w-100">--%>
<%--            <img class="card-img-top" src="Products/Slides.webp"--%>
<%--                 alt="Card image cap">--%>
<%--            <div class="card-body">--%>
<%--                <h5 class="card-title">Adidas Slide</h5>--%>
<%--                <h6 class="price">Price:₦30,000</h6>--%>
<%--                <h6 class="category">Category: Slides</h6>--%>
<%--                <div class="mt-3 d-flex justify-content-between">--%>
<%--                    <a class="btn btn-success" >Add to Cart</a>--%>
<%--                    <a class="btn btn-primary">Buy Now</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<br>--%>
<%--&lt;%&ndash;<% try {&ndash;%&gt;--%>
<%--&lt;%&ndash;    out.print(DataBaseConnection.getConnection());&ndash;%&gt;--%>
<%--&lt;%&ndash;} catch (SQLException|ClassNotFoundException e) {&ndash;%&gt;--%>
<%--&lt;%&ndash;    throw new RuntimeException(e);&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="hello-servlet">Hello Servlet</a>&ndash;%&gt;--%>
<%--<%@include file="WEB-INF/Includes/footer.jsp"%>--%>
<%--</body>--%>
<%--</html>--%>



<%
    Users auth = (Users) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ProductsDao pd = new ProductsDao(DataBaseConnection.getConnection());
    List<Products> products = pd.getAllProducts();
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/Includes/head.jsp"%>
    <title> Cart</title>
</head>
<body>
<%@include file="/WEB-INF/Includes/NavBar.jsp"%>

<div class="container">
    <div class="card-header my-3">Foot-Wears just for you!!</div>
    <div class="row">
        <%
            if (!products.isEmpty()) {
                for (Products prod : products) {
        %>
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="Products/<%=prod.getImages() %>"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=prod.getProductName() %></h5>
                    <h6 class="price">Price:₦<%=prod.getProductPrice() %></h6>
                    <h6 class="category">Category: <%=prod.getProductCategory() %></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="CartServlet?id=<%=prod.getProductId()%>">Add to Cart</a> <a
                            class="btn btn-primary" href="order-now?quantity=1&id=<%=prod.getProductId()%>">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            } else {
                out.println("There are no products");
            }
        %>

    </div>
</div>

<%@include file="WEB-INF/Includes/footer.jsp"%>
</body>
</html>