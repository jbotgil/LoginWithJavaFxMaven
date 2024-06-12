package com.example.loginwithjavafxmaven.view;

import com.example.loginwithjavafxmaven.controller.LoginSuccessfulController;
import javafx.event.ActionEvent;

public class LoginSuccessfulView {

    LoginSuccessfulController loginSuccessfulController = new LoginSuccessfulController();
    @javafx.fxml.FXML
    public void menuIniciarSesion(ActionEvent actionEvent) {
       loginSuccessfulController.menuLoginSuccessful(actionEvent);
    }
}