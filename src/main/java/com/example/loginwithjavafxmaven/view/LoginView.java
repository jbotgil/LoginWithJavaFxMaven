package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.controller.LoginController;
import com.example.loginwithjavafxmaven.controller.LoginSuccessfulController;
import com.example.loginwithjavafxmaven.controller.RegisterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
    @javafx.fxml.FXML
    private TextField mailField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
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


    //Inicio de sesion
    @javafx.fxml.FXML
    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String mail = mailField.getText();
        String password = passwordField.getText();

        boolean sesion;

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
    }

}