package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.controller.NameCheckerController;
import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.util.SQLiteConnector;
import com.example.loginwithjavafxmaven.view.AlertasView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RepositoryRegister {

    AlertasView alertasView = new AlertasView();
    RepositoryMailValidator repositoryMailValidator = new RepositoryMailValidator();
    NameCheckerController nameCheckerController = new NameCheckerController();
    RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();

    //Controlar si el correo existe
    private static boolean correoExiste = false;
    //Controla si el correo existe en nustra base de datos
    private static boolean correoValido = false;
    //Controla si el nombre es valido
    private static boolean nombreValido = false;
    private double guardarAltura;
    private double guardarAncho;
    int siguienteId;

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

    public void registrarse(ActionEvent actionEvent, String email, String passwd, String passwdVerificar, String nombreCompleto) {
        SQLiteConnector connector = SQLiteConnector.getInstance();
        RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();
        List<Usuario> usuarios = repositoryUsuarios.getUsuarios();

        String sql = "INSERT INTO Usuarios(id, nombreCompleto, email, passwd) VALUES (?, ?, ?, ?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Validate name
            if (!nameCheckerController.validarNombre(nombreCompleto)) {
                alertasView.mostrarAlerta("Error", "Nombre inválido.", Alert.AlertType.WARNING);
                return;
            }

            // Validate email
            if (!repositoryMailValidator.validarMail(email)) {
                alertasView.mostrarAlerta("Error", "Correo inválido", Alert.AlertType.WARNING);
                return;
            }

            // Check if email exists
            if (repositoryUsuarios.buscarUsuario(usuarios, email) != null) {
                alertasView.mostrarAlerta("Error", "Correo electrónico existente.", Alert.AlertType.ERROR);
                return;
            }

            int siguienteId = usuarios.size() + 1;

            pstmt.setInt(1, siguienteId);
            pstmt.setString(2, nombreCompleto);
            pstmt.setString(3, email);
            pstmt.setString(4, passwd);

            if (passwd.equals(passwdVerificar) && !passwd.isBlank()) {
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario registrado correctamente!");
                    alert.showAndWait();
                }
            } else {
                alertasView.mostrarAlerta("Error", "Las contraseñas no coinciden o están en blanco.", Alert.AlertType.WARNING);
            }
        } catch (SQLException e) {
            alertasView.mostrarAlerta("Error", "Error al registrar usuario", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}