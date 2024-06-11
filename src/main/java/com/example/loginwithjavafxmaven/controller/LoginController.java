package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private Hyperlink crearCuenta;

    //guardamos la altura y el ancho para que al cambiar al register la pantalla no se vuelva a redimensionar
    private double guardarAltura;
    private double guardarAncho;
    @FXML
    private TextField mailField;

    public double getGuardarAltura() {
        return guardarAltura;
    }

    public void setGuardarAltura(double guardarAltura) {
        this.guardarAltura = guardarAltura;
    }

    public double getGuardarAncho() {
        return guardarAncho;
    }

    public void setGuardarAncho(double guardarAncho) {
        this.guardarAncho = guardarAncho;
    }

    @FXML
    private void handleLoginButtonAction() {
        String mail = mailField.getText();
        String password = passwordField.getText();

        //todo: pensar que tipo de comunicacion de base de datos quiero para este programa (local/nube)

        //todo: conectarme a la base de datos a trabes de la carpeta model

        //todo: instanciar una conexión a la base de datos para poder hacer la validacion de del correo + contraseña

    }

    @FXML
    public void menuCrearCuenta(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("RegisterView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            //Guardamos el alto y el ancho de la pantalla
            this.setGuardarAltura(stage.getHeight());
            this.setGuardarAncho(stage.getWidth());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}