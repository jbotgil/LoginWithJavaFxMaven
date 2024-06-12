package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.view.LoginSuccessfulView;
import com.example.loginwithjavafxmaven.view.LoginView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class ReporitoryLoginSuccessful {

    @javafx.fxml.FXML
    public void menuLoginSuccess(ActionEvent actionEvent) {
        try {
            //creamos un objeto loader y cogemos sus controlles (configuraciones)
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginSuccessful.fxml"));
            Parent root = loader.load();
            LoginView loginView = loader.getController();

            Stage stage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();

            //Le asignamos la altura y el ancho a la escena
            stage.setWidth(loginView.getGuardarAltura());
            stage.setHeight(loginView.getGuardarAncho());

            stage.setTitle("Login Success");

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /*@javafx.fxml.FXML
    public void menuCrearCuenta(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("RegisterView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();

            stage.setMinWidth(310);
            stage.setMinHeight(355);

            //Aplicamos la misma resolucion del login para que en el momento de cambiar de pestaña se vea más fluido
            stage.setWidth(getGuardarAncho());
            stage.setHeight(getGuardarAltura());

            stage.setTitle("Register");

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }*/

}
