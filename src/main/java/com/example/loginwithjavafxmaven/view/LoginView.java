package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.controller.LoginController;
import com.example.loginwithjavafxmaven.controller.RegisterController;
import com.example.loginwithjavafxmaven.model.ModelRegister;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView {
    @javafx.fxml.FXML
    private TextField mailField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Hyperlink crearCuenta;

    RegisterController registerController = new RegisterController();
    LoginController loginController = new LoginController();

    private double guardarAltura;
    private double guardarAncho;

    public double getGuardarAltura() {
        return guardarAltura;
    }
    public double getGuardarAncho() {
        return guardarAncho;
    }


    @javafx.fxml.FXML
    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String mail = mailField.getText();
        String password = passwordField.getText();

        loginController.validarMail(mail);


        //todo: pensar que tipo de comunicacion de base de datos quiero para este programa (local/nube)

        //todo: conectarme a la base de datos a trabes de la carpeta model

        //todo: instanciar una conexión a la base de datos para poder hacer la validacion de del correo + contraseña
    }

    @javafx.fxml.FXML
    public void menuCrearCuenta(ActionEvent actionEvent) {
        registerController.menuCrearCuenta(actionEvent);
    }

}
