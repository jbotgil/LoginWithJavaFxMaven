package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.repositories.RepositoryRegister;
import javafx.event.ActionEvent;

public class ModelRegister {

    RepositoryRegister repositoryRegister = new RepositoryRegister();


    public void menuCrearCuenta(ActionEvent actionEvent) {
        repositoryRegister.menuCrearCuenta(actionEvent);
    }

}
