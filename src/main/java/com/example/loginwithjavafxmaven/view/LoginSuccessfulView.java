package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.controller.LoginSuccessfulController;
import javafx.event.ActionEvent;

public class LoginSuccessfulView {

    private double guardarAltura;
    private double guardarAncho;

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

    LoginSuccessfulController loginSuccessfulController = new LoginSuccessfulController();
    @javafx.fxml.FXML
    public void menuIniciarSesion(ActionEvent actionEvent) {
       loginSuccessfulController.menuLoginSuccessful(actionEvent);
    }
}