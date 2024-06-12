package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.view.LoginSuccessfulView;
import javafx.event.ActionEvent;

public class ReporitoryLoginSuccessful {
    LoginSuccessfulView loginSuccessfulView = new LoginSuccessfulView();

    public void menuLogin(ActionEvent actionEvent){
        loginSuccessfulView.menuIniciarSesion(actionEvent);
    }

}
