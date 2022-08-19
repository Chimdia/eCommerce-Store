package com.Controllers;

import Connections.DataBaseConnection;
import com.Dao.UserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            UserDao userdao = new UserDao(DataBaseConnection.getConnection());
            String UserName = request.getParameter("UserName");
            String Email = request.getParameter("Email");
            String Passwords = request.getParameter("Passwords");
            String Address = request.getParameter("Address");
            System.out.println(UserName + Email);


            Users users = new Users(UserName, Email, Passwords, Address);
            userdao.SignUp(users);
            response.sendRedirect("Login.jsp");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}




