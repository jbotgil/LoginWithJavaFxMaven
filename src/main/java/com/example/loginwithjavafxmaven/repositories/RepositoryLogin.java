package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.controller.UsuarioController;
import com.example.loginwithjavafxmaven.dao.Usuario;
import javafx.scene.control.Alert;

import java.util.List;

public class RepositoryLogin {

    RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();
    UsuarioController usuarioController = new UsuarioController();


    public boolean iniciarSesion(String email, String passwd){
        List<Usuario> usuarios = repositoryUsuarios.getUsuarios();

        //Primero comprobamos si existe el correo electronico dentro de la base de datos
        Usuario usu = usuarioController.buscarUsuario(usuarios,email);


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