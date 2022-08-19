<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@include file="/WEB-INF/Includes/head.jsp"%>
</head>
<body>
<%@include file="WEB-INF/Includes/NavBar.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Login</div>
        <div class="card-body">
            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label>Email address</label>
                    <input type="email" name="Email" class="form-control" placeholder="Enter email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="Passwords" class="form-control" placeholder="*********" required>
                </div>
                <div class="text-center">
                    <a href="SignUp.jsp"><span>SignUp</span></a>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%@include file="/WEB-INF/Includes/footer.jsp"%>
</body>
</html>