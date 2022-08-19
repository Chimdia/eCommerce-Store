package com.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
                if(request.getSession().getAttribute("auth")!=null) {
                    request.getSession().removeAttribute("auth");
                    response.sendRedirect("Login.jsp");
                }else {
                    response.sendRedirect("index.jsp");
                }

            }
        }

}


