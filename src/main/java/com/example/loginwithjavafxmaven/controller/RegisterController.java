package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.model.ModelRegister;
import javafx.event.ActionEvent;

public class RegisterController {
    ModelRegister modelRegister = new ModelRegister();

    public void registrarse(ActionEvent actionEvent, String email, String passwd, String passwdVerificar, String nombreCompleto){
        modelRegister.registrarse(actionEvent,email,passwd,passwdVerificar,nombreCompleto);
    }
}
