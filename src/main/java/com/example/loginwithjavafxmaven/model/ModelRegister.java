package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.repositories.RepositoryRegister;
import javafx.event.ActionEvent;

public class ModelRegister {
    RepositoryRegister repositoryRegister = new RepositoryRegister();

    public void registrarse(ActionEvent actionEvent, String email, String passwd, String passwdVerificar, String nombreCompleto){
        repositoryRegister.registrarse(actionEvent,email,passwd,passwdVerificar,nombreCompleto);
    }

}
