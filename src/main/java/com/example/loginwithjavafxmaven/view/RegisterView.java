package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.controller.LoginController;
import com.example.loginwithjavafxmaven.model.ModelLogin;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterView {
    @javafx.fxml.FXML
    private TextField mailField;
    @javafx.fxml.FXML
    private PasswordField repitPasswordField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Hyperlink iniciarSesion;
    @javafx.fxml.FXML
    private TextField nombreField;

    LoginController loginController = new LoginController();

    @javafx.fxml.FXML
    public void handleRegisterButtonAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void menuIniciarSesion(ActionEvent actionEvent) {
        loginController.menuLogin(actionEvent);
    }
}
