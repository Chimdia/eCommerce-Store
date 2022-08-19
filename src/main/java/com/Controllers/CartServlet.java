package com.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
//        	out.print("add to cart servlet");

            ArrayList<Cart> cartList = new ArrayList<>();
            int productId = Integer.parseInt(request.getParameter("id"));
            Cart cart = new Cart();
            cart.setProductId(productId);
            cart.setProductQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<Cart> cartItems = (ArrayList<Cart>) session.getAttribute("cart-list");
            if (cartItems == null) {
                cartList.add(cart);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            } else {
                cartList = cartItems;

                boolean exist = false;
                for (Cart c : cartItems) {
                    if (c.getProductId() == productId) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already Selected. <a href='Cart.jsp'>Cart</a></h3>");
                    }
                }

                if (!exist) {
                    cartList.add(cart);
                    response.sendRedirect("index.jsp");
                }
            }
        }
    }

}