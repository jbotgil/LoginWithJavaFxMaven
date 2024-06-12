module com.example.loginwithjavafxmaven {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires java.sql;


    opens com.example.loginwithjavafxmaven to javafx.fxml;

    exports com.example.loginwithjavafxmaven;
    exports com.example.loginwithjavafxmaven.controller;
    exports com.example.loginwithjavafxmaven.view;
    exports com.example.loginwithjavafxmaven.dao;

    opens com.example.loginwithjavafxmaven.view to javafx.fxml;
    exports com.example.loginwithjavafxmaven.repositories;


}