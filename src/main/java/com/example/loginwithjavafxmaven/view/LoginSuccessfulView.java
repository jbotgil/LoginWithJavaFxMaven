package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSuccessfulView {

    private double guardarAltura;
    private double guardarAncho;

    public double getGuardarAltura() {
        return guardarAltura;
    }

    public double getGuardarAncho() {
        return guardarAncho;
    }

    @javafx.fxml.FXML
    public void menuLoginSuccess(ActionEvent actionEvent) {
        try {
            // Cargamos el FXML y obtenemos su controlador
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginSuccessful.fxml"));
            Parent root = loader.load();
            LoginSuccessfulView loginSuccessfulView = loader.getController(); // Cambiado a LoginSuccessfulView

            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // Cambiado a Button

            // Le asignamos la altura y el ancho a la escena usando LoginSuccessfulView
            stage.setWidth(loginSuccessfulView.getGuardarAltura());
            stage.setHeight(loginSuccessfulView.getGuardarAncho());

            stage.setTitle("Login Success");

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}