package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.view.LoginView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class RepositoryLogin {

    RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();

    @javafx.fxml.FXML
    public void menuIniciarSesion(ActionEvent actionEvent) {
        try {
            //creamos un objeto loader y cogemos sus controlles (configuraciones)
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));
            Parent root = loader.load();
            LoginView loginView = loader.getController();

            Stage stage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();

            //Le asignamos la altura y el ancho a la escena
            stage.setWidth(loginView.getGuardarAltura());
            stage.setHeight(loginView.getGuardarAncho());

            stage.setTitle("Login");

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public boolean iniciarSesion(String email, String passwd){
        List<Usuario> usuarios = repositoryUsuarios.getUsuarios(); //Usuarios de la base de datos

        //Primero comprobamos si existe el correo electronico dentro de la base de datos
        Usuario usu = repositoryUsuarios.buscarUsuario(usuarios,email);
        if (usu == null){ //Controlamos la excepcion, ya que a la hora de iniciar sesion si introducimos un usuario invalido el usuario sera null
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de inicio de sesion");
            alert.showAndWait();
        }

        if ((email.equals(usu.getEmail()))&& passwd.equals(usu.getPasswd())){
            System.out.println("Inicio de sesion correcto");
            return true;
        } else {
            System.out.println("Inicio de sesion incorrecto.");
            return false;
        }
    }
}