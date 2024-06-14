package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.view.LoginSuccessfulView;
import javafx.event.ActionEvent;

public class ModelLoginSuccessful {
    LoginSuccessfulView loginSuccessfulView = new LoginSuccessfulView();

    public void menuLoginSuccessful(ActionEvent actionEvent){
        loginSuccessfulView.menuLoginSuccess(actionEvent);
    }

}
