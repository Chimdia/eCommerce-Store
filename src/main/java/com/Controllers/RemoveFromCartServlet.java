package com.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet( "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String shoeId = request.getParameter("productId");
            if (shoeId != null) {
                ArrayList<Cart> cartItems = (ArrayList<Cart>) request.getSession().getAttribute("cartItems");
                if (cartItems != null) {
                    for (Cart c : cartItems) {
                        if (c.getProductId() == Integer.parseInt(shoeId)) {
                            cartItems.remove(c);
                            break;
                        }
                    }
                }
                response.sendRedirect("Cart.jsp");

            } else {
                response.sendRedirect("Cart.jsp");
            }

        }
    }

}

//
//public class RemoveFromCartServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String bookId = request.getParameter("id");
//            if (bookId != null) {
//                ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//                if (cart_list != null) {
//                    for (Cart c : cart_list) {
//                        if (c.getId() == Integer.parseInt(bookId)) {
//                            cart_list.remove(cart_list.indexOf(c));
//                            break;
//                        }
//                    }
//                }
//                response.sendRedirect("cart.jsp");
//
//            } else {
//                response.sendRedirect("cart.jsp");
//            }
//
//        }
//    }
//
//}
