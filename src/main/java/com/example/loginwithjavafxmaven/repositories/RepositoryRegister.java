package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.controller.NameCheckerController;
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

public class RepositoryRegister {

    //variable para controlar si el correo existe
    private static boolean correoExiste = false;
    //variable para controlar si el nombre es valido
    private static boolean nombreValido = false;
    private double guardarAltura;
    private double guardarAncho;

    public static boolean isCorreoExiste() {
        return correoExiste;
    }

    public static boolean isNombreValido() {
        return nombreValido;
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

    public void registrarse(String email, String passwd, String passwdVerificar, String nombreCompleto){
        try {
            /**
             * Validamos el nombre
             *
             * Nombres valido: 1 o 2 nombres y 1 o 2 apellidos
             *
             * En caso de ser verdadero, no saltará ninguna alerta y el metodo devolverá true,
             * en caso contrario, devolverá false y lanzará una alerta
             *
             * Lo metemos dentro de una variable para que después sea mas facil validar*/
            setNombreValido(nameCheckerController.validarNombre(nombreCompleto));

            //Validamos que el email existe y lo introducimos dentro de la variable correoExiste
            setCorreoExiste(repositoryMailValidator.validarMail(email));

            //todo:Validamos si el mail existe en nuestra base de datos


            //todo:Enviamos un mail de confirmación (si es posible, ya que en un entorno local no sé si esto se podría hacer)


        } catch (Exception e) {
            // Error al validar el correo electrónico
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ha ocurrido un error al validar el correo electrónico.");
            alert.showAndWait();
        }
    }


}
