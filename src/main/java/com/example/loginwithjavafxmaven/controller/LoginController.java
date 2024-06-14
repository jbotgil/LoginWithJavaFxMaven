package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.model.ModelLogin;

public class LoginController {
    ModelLogin modelLogin = new ModelLogin();

    public boolean iniciarSesion(String mail, String passwd){
        return modelLogin.iniciarSesion(mail,passwd);
    }
}