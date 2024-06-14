package com.example.loginwithjavafxmaven.view;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class AlertasView {

    public void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        // Crea la alerta
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        // Añadir el ícono personalizado
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/appIcon.png"))));

        // Mostrar la alerta
        alert.showAndWait();
    }
}