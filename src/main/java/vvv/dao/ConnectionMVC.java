package main.java.vvv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMVC{

    public Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vvv_projeto?useSSL=false", "root", "cefetmg092022");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}