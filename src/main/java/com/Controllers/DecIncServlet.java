package com.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/DecIncServlet")
public class DecIncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    String action = request.getParameter("action");
                    int productId = Integer.parseInt(request.getParameter("productId"));
                    ArrayList<Cart> cartItems = (ArrayList<Cart>) request.getSession().getAttribute("cartItems");

                    if (action != null && productId >= 1) {
                        if (action.equals("inc")) {
                            for (Cart c : cartItems) {
                                if (c.getProductId() == productId) {
                                    int productQuantity = c.getProductQuantity();
                                    productQuantity++;
                                    c.setProductQuantity(productQuantity);
                                    response.sendRedirect("Cart.jsp");
                                }
                            }
                        }

                        if (action.equals("dec")) {
                            for (Cart c : cartItems) {
                                if (c.getProductId() == productId && c.getProductQuantity() > 1) {
                                    int quantity = c.getProductQuantity();
                                    quantity--;
                                    c.setProductQuantity(quantity);
                                    break;
                                }
                            }
                            response.sendRedirect("Cart.jsp");
                        }
                    } else {
                        response.sendRedirect("Cart.jsp");
                    }
                }
            }

        }

