package com.example.ems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class query {

    private static final String db_driver = "com.mysql.cj.jdbc.Driver";
    private static final String db_url = "jdbc:mysql://localhost:3306/Employees";
    private static final String db_username = "root";
    private static final String db_password = "@Jan142009!@";




    public query(String firstName) throws SQLException, ClassNotFoundException {

        Class.forName(db_driver);
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

        String mainQ = "SELECT * FROM employees WHERE FName = ?";
        PreparedStatement ptst = connection.prepareStatement(mainQ);
        ptst.setString(1,firstName);
        ResultSet rs = ptst.executeQuery();

        while(rs.next()){
            System.out.print("First Name: " + rs.getString("FName"));
            System.out.print(", Last Name: " + rs.getString("LName"));
            System.out.print(", Employee ID: " + rs.getInt("empId"));
            System.out.println(", Dep: " + rs.getString("department"));
            System.out.println(", Salary" + rs.getInt("salary"));
        }
        rs.close();

    }

    public query(int empid) throws SQLException, ClassNotFoundException {

        Class.forName(db_driver);
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

        String mainQ = "SELECT * FROM employees WHERE empId = ?";
        PreparedStatement ptst = connection.prepareStatement(mainQ);
        ptst.setInt(1,empid);
        ResultSet rs = ptst.executeQuery();

        while(rs.next()){
            System.out.print("First Name: " + rs.getString("FName"));
            System.out.print(", Last Name: " + rs.getString("LName"));
            System.out.print(", Employee ID: " + rs.getInt("empId"));
            System.out.println(", Dep: " + rs.getString("department"));
            System.out.println(", Salary" + rs.getInt("salary"));
        }
        rs.close();

    }

    public query(String firstName, int empid) throws SQLException, ClassNotFoundException {
        Class.forName(db_driver);
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

        String mainQ = "SELECT * FROM employees WHERE empId = ? and  FName = ?";
        PreparedStatement ptst = connection.prepareStatement(mainQ);
        ptst.setInt(1,empid);
        ptst.setString(2, firstName);
        ResultSet rs = ptst.executeQuery();

        while(rs.next()){
            System.out.print("First Name: " + rs.getString("FName"));
            System.out.print(", Last Name: " + rs.getString("LName"));
            System.out.print(", Employee ID: " + rs.getInt("empId"));
            System.out.println(", Dep: " + rs.getString("department"));
            System.out.println(", Salary" + rs.getInt("salary"));
        }
        rs.close();

    }

    public query(String firstName, String lastName) throws SQLException, ClassNotFoundException {
        Class.forName(db_driver);
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

        String mainQ = "SELECT * FROM employees WHERE FName = ? and  LName = ?";
        PreparedStatement ptst = connection.prepareStatement(mainQ);
        ptst.setString(1, firstName);
        ptst.setString(2,lastName);
        ResultSet rs = ptst.executeQuery();

        while(rs.next()){
            System.out.print("First Name: " + rs.getString("FName"));
            System.out.print(", Last Name: " + rs.getString("LName"));
            System.out.print(", Employee ID: " + rs.getInt("empId"));
            System.out.println(", Dep: " + rs.getString("department"));
            System.out.println(", Salary" + rs.getInt("salary"));
        }
        rs.close();


    }

    public query() throws ClassNotFoundException, SQLException {
        Class.forName(db_driver);
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

        String mainQ = "SELECT * FROM employees";
        PreparedStatement ptst = connection.prepareStatement(mainQ);
        ResultSet rs = ptst.executeQuery();

        while(rs.next()){
            System.out.print("First Name: " + rs.getString("FName"));
            System.out.print(", Last Name: " + rs.getString("LName"));
            System.out.print(", Employee ID: " + rs.getInt("empId"));
            System.out.println(", Dep: " + rs.getString("department"));
            System.out.println(", Salary" + rs.getInt("salary"));
        }
        rs.close();
    }


}
