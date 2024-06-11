package com.example.loginwithjavafxmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 500, 400);

        stage.setTitle("Login");

        Image image = new Image(getClass().getResourceAsStream("/com/example/loginwithjavafxmaven/icons/appIcon.png")); //guardamos la imagen

        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}