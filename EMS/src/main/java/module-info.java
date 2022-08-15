module com.example.ems {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.ems to javafx.fxml;
    exports com.example.ems;
}