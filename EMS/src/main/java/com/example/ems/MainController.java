package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainController {

    @FXML
    private TextField FNameInp;
    @FXML
    private TextField LNameInp;
    @FXML
    private TextField empInp;
    @FXML
    private TextField depInp;
    @FXML
    private TextField salaryInp;
    @FXML
    private TableView tableSearch;


    private static final String db_driver = "com.mysql.cj.jdbc.Driver";
    private static final String db_url = "jdbc:mysql://localhost:3306/Employees";
    private static final String db_username = "root";
    private static final String db_password = "@Jan142009!@";
    public void searchButton(ActionEvent e) throws ClassNotFoundException {
        String firstName = FNameInp.getText();
        String lastName = LNameInp.getText();
        String empID = empInp.getText();
        String department = depInp.getText();
        String salary = salaryInp.getText();

        try {
            Class.forName(db_driver);
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

            if(!firstName.isBlank() || !empID.isBlank()){
                if (!firstName.isBlank() && empID.isBlank()) {
                    query fnameQ = new query(firstName);

                }
                else if (!empID.isBlank() && firstName.isBlank()){
                    int empid = Integer.parseInt(empID);
                    query empQ = new query(empid);
                }
            }

            if(!department.isBlank()){
                query depQ = new query(department);

            }

            else if (!firstName.isBlank() && !empID.isBlank()){
                int empid = Integer.parseInt(empID);
                query fnameID = new query(firstName, empid);
            }

            else if (!firstName.isBlank() && !lastName.isBlank()){

                query fullName = new query(firstName,lastName);
            }


            else {
                query fullemp = new query();
            }
        }

        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void resetButton(ActionEvent e) {
        FNameInp.setText("");
        LNameInp.setText("");
        empInp.setText("");
        depInp.setText("");
        salaryInp.setText("");

    }

    public void exportToCSV(ActionEvent e){
        System.out.println("Exporting Now!");
    }
}
