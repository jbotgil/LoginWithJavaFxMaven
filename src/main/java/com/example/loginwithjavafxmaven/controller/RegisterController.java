package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.model.ModelRegister;
import com.example.loginwithjavafxmaven.repositories.RepositoryMailValidator;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @javafx.fxml.FXML
    private Hyperlink iniciarSesion;
    @javafx.fxml.FXML
    private TextField mailField;
    @javafx.fxml.FXML
    private PasswordField repitPasswordField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private TextField nombreField;

    //variable para controlar si el correo existe
    private static boolean correoExiste = false;
    //variable para controlar si el nombre es valido
    private static boolean nombreValido = false;

    ModelRegister modelRegister = new ModelRegister();

    @javafx.fxml.FXML
    public void handleRegisterButtonAction(ActionEvent actionEvent) {
        RepositoryMailValidator repositoryMailValidator = new RepositoryMailValidator();
        NameCheckerController nameCheckerController = new NameCheckerController();
        try {


             /** Validamos el nombre
             *
             * Nombres valido: 1 o 2 nombres y 1 o 2 apellidos
             *
             * En caso de ser verdadero, no saltará ninguna alerta y el metodo devolverá true,
             * en caso contrario, devolverá false y lanzará una alerta
             *
             * Lo metemos dentro de una variable para que después sea mas facil validar*/

            nombreValido = nameCheckerController.validarNombre(nombreField.getText());



             /** Validamos el mail
             *
             * En caso de ser verdadero, no saltará ninguna alerta y el metodo devolverá true,
             * en caso contrario, devolverá false y lanzará una alerta
             *
             * Lo metemos dentro de una variable para que después sea mas facil validar*/

            correoExiste = repositoryMailValidator.validarMail(mailField.getText());

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

    public void menuCrearCuenta(ActionEvent actionEvent) {
        modelRegister.menuCrearCuenta(actionEvent);
    }

}
