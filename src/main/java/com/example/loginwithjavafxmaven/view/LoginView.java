package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.controller.LoginController;
import com.example.loginwithjavafxmaven.controller.LoginSuccessfulController;
import com.example.loginwithjavafxmaven.controller.RegisterController;
import com.example.loginwithjavafxmaven.model.ModelRegister;
import com.example.loginwithjavafxmaven.repositories.RepositoryLogin;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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

    LoginSuccessfulController loginSuccessfulController = new LoginSuccessfulController();

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

        boolean sesion = false;

        if ((!mail.isBlank())||(!password.isBlank())){
            sesion = loginController.iniciarSesion(mail,password); //Lanzamos el inicio de sesion
            if (sesion){
                loginSuccessfulController.menuLoginSuccessful(actionEvent);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de inicio de sesion");
            alert.showAndWait();
        }

    }

    @javafx.fxml.FXML
    public void menuCrearCuenta(ActionEvent actionEvent) {
        registerController.menuCrearCuenta(actionEvent);
    }

}