package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.controller.RegisterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterView {
    @javafx.fxml.FXML
    private TextField mailField;
    @javafx.fxml.FXML
    private PasswordField repitPasswordField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private TextField nombreField;
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
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));
            Parent root = loader.load();
            LoginView loginView = loader.getController();

            Stage stage;
            if (actionEvent.getSource() instanceof Stage) {
                stage = (Stage) actionEvent.getSource();
            } else {
                // Correctly handle various types of nodes
                stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            }

            //Le asignamos la altura y el ancho a la escena
            stage.setWidth(loginView.getGuardarAltura());
            stage.setHeight(loginView.getGuardarAncho());

            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}