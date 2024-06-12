package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.model.ModelLogin;
import com.example.loginwithjavafxmaven.view.LoginView;
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

    ModelLogin modelLogin = new ModelLogin();


    public void menuLogin(ActionEvent actionEvent){
        modelLogin.menuLogin(actionEvent);
    }

    public boolean validarMail(String correo){
        return modelLogin.validarMail(correo);
    }

    public boolean iniciarSesion(String mail, String passwd){
        return modelLogin.iniciarSesion(mail,passwd);
    }


}