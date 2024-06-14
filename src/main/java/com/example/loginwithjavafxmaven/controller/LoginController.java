package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.model.ModelLogin;
import javafx.event.ActionEvent;

public class LoginController {
    ModelLogin modelLogin = new ModelLogin();

    public void menuLogin(ActionEvent actionEvent){
        modelLogin.menuLogin(actionEvent);
    }

    public boolean iniciarSesion(String mail, String passwd){
        return modelLogin.iniciarSesion(mail,passwd);
    }
}