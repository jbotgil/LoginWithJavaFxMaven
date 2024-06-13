package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.controller.NameCheckerController;
import com.example.loginwithjavafxmaven.util.SQLiteConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RepositoryRegister {
    private SQLiteConnector connector = SQLiteConnector.getInstance();

    //Controlar si el correo existe
    private static boolean correoExiste = false;
    //Controla si el correo existe en nustra base de datos
    private static boolean correoValido = false;
    //Controla si el nombre es valido
    private static boolean nombreValido = false;
    private double guardarAltura;
    private double guardarAncho;

    public static boolean isCorreoExiste() {
        return correoExiste;
    }

    public static boolean isNombreValido() {
        return nombreValido;
    }

    public static boolean isCorreoValido() {
        return correoValido;
    }

    public static void setCorreoValido(boolean correoValido) {
        RepositoryRegister.correoValido = correoValido;
    }

    public static void setCorreoExiste(boolean correoExiste) {
        RepositoryRegister.correoExiste = correoExiste;
    }

    public static void setNombreValido(boolean nombreValido) {
        RepositoryRegister.nombreValido = nombreValido;
    }

    public double getGuardarAltura() {
        return guardarAltura;
    }

    public void setGuardarAltura(double guardarAltura) {
        this.guardarAltura = guardarAltura;
    }

    public double getGuardarAncho() {
        return guardarAncho;
    }

    public void setGuardarAncho(double guardarAncho) {
        this.guardarAncho = guardarAncho;
    }

    RepositoryMailValidator repositoryMailValidator = new RepositoryMailValidator();
    NameCheckerController nameCheckerController = new NameCheckerController();
    RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();


    @javafx.fxml.FXML
    public void menuCrearCuenta(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("RegisterView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();

            stage.setMinWidth(310);
            stage.setMinHeight(355);

            //Aplicamos la misma resolucion del login para que en el momento de cambiar de pestaña se vea más fluido
            stage.setWidth(getGuardarAncho());
            stage.setHeight(getGuardarAltura());

            stage.setTitle("Register");

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registrarse(ActionEvent actionEvent,String email, String passwd, String passwdVerificar, String nombreCompleto) {

        String sql = "INSERT INTO Usuarios(nombreCompleto,email,passwd) VALUES(?,?,?)";

        try (var conn = connector.getConnection();
             var pstmt = conn.prepareStatement(sql)) {

            // Validar nombre (no altero tu lógica de validación aquí)
            if (!nameCheckerController.validarNombre(nombreCompleto)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Nombre invalido.");
                alert.showAndWait();
                return;
            }

            // Validar correo existente
            if (repositoryUsuarios.buscarUsuario(email) != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Correo electronico existente.");
                alert.showAndWait();
                return;
            }

            // Insertar usuario si todo está validado
            pstmt.setString(1, nombreCompleto);
            pstmt.setString(2, email);
            pstmt.setString(3, passwd);

            pstmt.executeQuery();

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Usuario registrado correctamente!");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al registrar usuario: " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

}
