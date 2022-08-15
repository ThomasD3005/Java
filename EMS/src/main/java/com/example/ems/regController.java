package com.example.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class regController {

    private static final String db_driver = "com.mysql.cj.jdbc.Driver";
    private static final String db_url = "jdbc:mysql://localhost:3306/Employees";
    private static final String db_username = "root";
    private static final String db_password = "@Jan142009!@";


    public void register() throws ClassNotFoundException, SQLException {
        Class.forName(db_driver);
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

        System.out.println("Nice");

    }




}
