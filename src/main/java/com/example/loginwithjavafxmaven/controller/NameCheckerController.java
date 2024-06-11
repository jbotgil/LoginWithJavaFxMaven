package com.example.loginwithjavafxmaven.controller;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameCheckerController {

    //En esta variable guardaremos el nombre en caso de que sea valido
    private String nombreValido;

    public String getNombreValido() {
        return nombreValido;
    }

    public void setNombreValido(String nombreValido) {
        this.nombreValido = nombreValido;
    }


    // Definimos la expresión regular para comprobar el formato del nombre y apellidos
    private static final String NOMBRE_APELLIDOS_REGEX = "^([A-Za-zÀ-ÿ]+\\s+){1,3}[A-Za-zÀ-ÿ]+$"; //1 nombre minimo 2 maximo, 1 apellido minimo 2 maximo
    private static boolean esNombreValido(String nombre) {
        Pattern pattern = Pattern.compile(NOMBRE_APELLIDOS_REGEX);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }



     /** Metodo al que se llamará para comprobar que introducimos un nombre valido
     *
     * @param nombre el nombre que queramos validar
     * @return devuelve un boleano para verificar si el nombre es valido o no
      */


    public boolean validarNombre(String nombre){
        boolean esValido = false;
        if (esNombreValido(nombre)){ //Si el nombre es valido ...
            esValido = true;
            setNombreValido(nombre);
        } else {
            Alert nombreInvalido = new Alert(Alert.AlertType.ERROR);
            nombreInvalido.setTitle("Correo inválido");
            nombreInvalido.setHeaderText(null);
            nombreInvalido.setContentText("El nombre no es válido.");
            nombreInvalido.showAndWait();
        }
        return esValido; //En caso de no entrar al if es que el nombre no es valido
    }
}
