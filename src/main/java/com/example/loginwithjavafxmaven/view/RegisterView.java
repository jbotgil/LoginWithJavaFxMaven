package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.controller.LoginController;
import com.example.loginwithjavafxmaven.controller.RegisterController;
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
    RegisterController registerController = new RegisterController();

    @javafx.fxml.FXML
    public void handleRegisterButtonAction(ActionEvent actionEvent) {
        String mail = mailField.getText();
        String passwd = passwordField.getText();
        String passwdVerificar = repitPasswordField.getText();
        String nombreCompleto = nombreField.getText();

        registerController.registrarse(actionEvent,mail,passwd,passwdVerificar,nombreCompleto);
    }

    @javafx.fxml.FXML
    public void menuIniciarSesion(ActionEvent actionEvent) {
        loginController.menuLogin(actionEvent);
    }
}
