package com.example.loginwithjavafxmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 500, 400);

        //Titulo de la app
        stage.setTitle("Login");

        //Resolucion minima
        stage.setMinWidth(310);
        stage.setMinHeight(355);

        //Icono de la app
        Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/appIcon.png")));
        stage.getIcons().add(iconImage);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}