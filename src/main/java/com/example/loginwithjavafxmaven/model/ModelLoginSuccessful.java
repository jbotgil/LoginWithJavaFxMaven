package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.repositories.ReporitoryLoginSuccessful;
import javafx.event.ActionEvent;

public class ModelLoginSuccessful {
    ReporitoryLoginSuccessful reporitoryLoginSuccessful = new ReporitoryLoginSuccessful();

    public void menuLoginSuccessful(ActionEvent actionEvent){
        reporitoryLoginSuccessful.menuLogin(actionEvent);
    }

}
