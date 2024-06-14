package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.model.ModelRegister;
import com.example.loginwithjavafxmaven.repositories.RepositoryMailValidator;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    ModelRegister modelRegister = new ModelRegister();

    public void registrarse(ActionEvent actionEvent, String email, String passwd, String passwdVerificar, String nombreCompleto){
        modelRegister.registrarse(actionEvent,email,passwd,passwdVerificar,nombreCompleto);
    }

    public void menuCrearCuenta(ActionEvent actionEvent) {
        modelRegister.menuCrearCuenta(actionEvent);
    }

}
