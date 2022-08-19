package com.Dao;

import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Connection connection;
    private PreparedStatement prepareStatement;
    private ResultSet resultSet;


    private String query = "select * from users where Email=? and Passwords=?";

    private  String query1 = "INSERT INTO Users ( UserName, Email, Passwords, Address) VALUES(?,?,?,?)";
    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public Users userLogin(String email, String passwords) {
        Users users = new Users();
        try {
            prepareStatement = this.connection.prepareStatement(query);
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, passwords);
            System.out.println(prepareStatement);
            resultSet = prepareStatement.executeQuery();

            while(resultSet.next()) {
                users = new Users();
                users.setEmail(resultSet.getString("Email"));
                users.setPasswords(resultSet.getString("Passwords"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void SignUp(Users users) {
        int num =0;
        try{
            prepareStatement=this.connection.prepareStatement(query1);
            prepareStatement.setString(1, users.getUserName());
            prepareStatement.setString(2, users.getEmail());
            prepareStatement.setString(3, users.getPasswords());
            prepareStatement.setString(4, users.getAddress());
            System.out.println(prepareStatement);
            num =  prepareStatement.executeUpdate();
            System.out.println(num);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}