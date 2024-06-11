module com.example.loginwithjavafxmaven {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;


    opens com.example.loginwithjavafxmaven to javafx.fxml;

    exports com.example.loginwithjavafxmaven;
    exports com.example.loginwithjavafxmaven.controller;

    opens com.example.loginwithjavafxmaven.controller to javafx.fxml;

}