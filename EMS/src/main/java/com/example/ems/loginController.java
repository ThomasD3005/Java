package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javafx.fxml.FXML;
public class loginController {
    @FXML
    private TextField usernameInp;
    @FXML
    private TextField passwordInp;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static final String db_driver = "com.mysql.cj.jdbc.Driver";
    private static final String db_url = "jdbc:mysql://localhost:3306/Employees";
    private static final String db_username = "root";
    private static final String db_password = "@Jan142009!@";

    userPass loginInfo = new userPass();
    public void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        String username = usernameInp.getText();
        String password = passwordInp.getText();
        try {
            if (loginInfo.usersAndPass().containsKey(username)) {
                if (loginInfo.usersAndPass.get(username).equals(password)) {
                    Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void register(ActionEvent event) throws IOException {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();

        }
    }



}
