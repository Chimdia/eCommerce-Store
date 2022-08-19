<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <%@include file="/WEB-INF/Includes/head.jsp"%>
</head>
<body>
<%@include file="WEB-INF/Includes/NavBar.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">SignUp</div>
        <div class="card-body">
            <form action="SignUpServlet" method="post">
                <div class="form-group">
                    <label>UserName</label>
                    <input type="text" name="UserName" class="form-control" placeholder="John   Doe">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="Email" class="form-control" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" id="password" name="Passwords" class="form-control" placeholder="*********" required>
                    <input type="checkbox" onclick="showPassword()">Show Password
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="Address" class="form-control" placeholder="123 Lekpe Way">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">SignUp</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%@include file="/WEB-INF/Includes/footer.jsp"%>
<script>
    function showPassword() {
        let x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>
</body>
</html>