package com.Dao;

import model.Cart;
import model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao {
    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;


    public ProductsDao(Connection con) {
        super();
        this.con = con;
    }


    public List<Products> getAllProducts() {
        List<Products> shoes = new ArrayList<>();
        try {

            query = "select * from Products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Products products = new Products();
                products.setProductId(rs.getInt("productId"));
                products.setProductName(rs.getString("ProductName"));
                products.setProductCategory(rs.getString("productCategory"));
                products.setProductPrice(rs.getDouble("productPrice"));
                products.setProductQuantity(rs.getInt("productQuantity"));
                products.setImages(rs.getString("images"));

                shoes.add(products);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return shoes;
    }


    public Products getSingleProduct(int productId) {
        Products products = null;
        try {
            query = "select * from Products where productId=? ";

            pst = this.con.prepareStatement(query);
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                products = new Products();
                products.setProductId(rs.getInt("productId"));
                products.setProductName(rs.getString("productName"));
                products.setProductCategory(rs.getString("productCategory"));
                products.setProductPrice(rs.getDouble("productPrice"));
                products.setProductQuantity(rs.getInt("productQuantity"));
                products.setImages(rs.getString("images"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return products;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select productPrice from Products where productId=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getProductId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("productPrice")*item.getProductQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }


    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> shoes = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from Products where productId=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getProductId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart items = new Cart();
                        items.setProductId(rs.getInt("productId"));
                        items.setProductName(rs.getString("productName"));
                        items.setProductCategory(rs.getString("productCategory"));
                        items.setProductPrice(rs.getDouble("productPrice")*item.getProductQuantity());
                        items.setProductQuantity(rs.getInt("productQuantity"));
                        items.setProductQuantity(item.getProductQuantity());
                        shoes.add(items);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return shoes;
    }
}

