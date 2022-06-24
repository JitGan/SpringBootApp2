package com.example.springboot.DataAccessObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static Connection getMSSQLConnection(String url,String userName,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Loaded the driver url:"+url+" User:"+userName+" pwd:"+password);
        //Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Test_company?characterEncoding=latin1&useConfigs=maxPerformance","root","warlock72!");
        Connection con= DriverManager.getConnection(url,userName,password);
        return con;
    }
}
