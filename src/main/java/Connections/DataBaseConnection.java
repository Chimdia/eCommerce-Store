package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connection =null;

    public static  Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection ==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DIPSON_STORES","root","kingchimy@1759");
            System.out.println("connected");
        }
        return connection;
    }
}
