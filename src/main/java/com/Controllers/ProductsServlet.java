//package com.Controllers;
//
//import Connections.DataBaseConnection;
//import com.Dao.ProductsDao;
//import com.Dao.UserDao;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import model.Users;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//
//@WebServlet(name = "ProductServlet", value = "/ProductServlet")
//public class ProductsServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {{
//                response.setContentType("text/html;charset=UTF-8");
//                try (PrintWriter out = response.getWriter()) {
//                    ProductsDao userdao = new ProductsDao(DataBaseConnection.getConnection());
//                    String productId = request.getParameter("UserName");
//                    String productName = request.getParameter("productName");
//                    String productCategory = request.getParameter("productCategory");
//                    String productQuantity = request.getParameter("productQuantity");
//                    String productPrice = request.getParameter("productPrice");
//                    String images = request.getParameter("images");
//
//
//
//                    Users users = new Users(UserName, Email, Passwords, Address);
//                    userdao.SignUp(users);
//                    response.sendRedirect("Login.jsp");
//
//                } catch (IOException | ClassNotFoundException | SQLException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }
//        response.sendRedirect("Products.jsp");
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
