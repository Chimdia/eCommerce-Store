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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                String email = request.getParameter("Email");
                String password = request.getParameter("Passwords");

                UserDao userdao = new UserDao(DataBaseConnection.getConnection());
                Users users = userdao.userLogin(email, password);
                if (users.getPasswords() != null) {
                    if (users.getEmail().equals("AdminDipo@DipsonStores.com") && users.getPasswords().equals("AdminOladipupo@1759")) {
                        request.getSession().setAttribute("auth", users);
                        System.out.println("###########logged In");
                        response.sendRedirect("Admin Dashboard.jsp");
                    } else if (!users.getEmail().equals("AdminDipo@DipsonStores.com") && !users.getPasswords().equals("AdminOladipupo@1759")) {
                        request.getSession().setAttribute("auth", users);
                        System.out.println("###########logged In");
                        response.sendRedirect("index.jsp");

                    }
                }else{
                    response.sendRedirect("SignUp.jsp");
                }
            }catch (IOException | ClassNotFoundException | SQLException e){
                throw new RuntimeException(e);
            }

    }
}

