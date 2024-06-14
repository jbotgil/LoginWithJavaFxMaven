package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.repositories.RepositoryLogin;
import com.example.loginwithjavafxmaven.repositories.RepositoryMailValidator;
import javafx.event.ActionEvent;

public class ModelLogin {

    RepositoryLogin repositoryLogin = new RepositoryLogin();
    RepositoryMailValidator mailValidator = new RepositoryMailValidator();

    public void menuLogin(ActionEvent actionEvent){
        repositoryLogin.menuIniciarSesion(actionEvent);
    }


    public boolean iniciarSesion(String mail, String passwd){
        return repositoryLogin.iniciarSesion(mail,passwd);
    }

}
