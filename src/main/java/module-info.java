module com.bancodequestoes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.bdq to javafx.fxml;
    exports com.bdq;
    exports com.bdq.controllers;
    opens com.bdq.controllers to javafx.fxml;
    exports com.bdq.application;
    opens com.bdq.application to javafx.fxml;
}