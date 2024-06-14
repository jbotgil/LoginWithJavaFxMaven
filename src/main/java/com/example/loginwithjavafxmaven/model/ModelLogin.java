package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.repositories.RepositoryLogin;

public class ModelLogin {
    RepositoryLogin repositoryLogin = new RepositoryLogin();

    public boolean iniciarSesion(String mail, String passwd){
        return repositoryLogin.iniciarSesion(mail,passwd);
    }
}