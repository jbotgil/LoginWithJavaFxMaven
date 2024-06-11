package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.Main;
import com.example.loginwithjavafxmaven.controller.LoginController;
import com.example.loginwithjavafxmaven.controller.MailValidatorController;
import com.example.loginwithjavafxmaven.controller.NameCheckerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

    @javafx.fxml.FXML
    public void handleRegisterButtonAction(ActionEvent actionEvent) {
        MailValidatorController mailValidatorController = new MailValidatorController();
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

            correoExiste = mailValidatorController.validarMail(mailField.getText());

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

    @javafx.fxml.FXML
    public void menuIniciarSesion(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));

            Parent root = loader.load();

            //creamos un objeto loader y cogemos sus controlles
            LoginController loginController = loader.getController();

            Stage stage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();

            //Le asignamos la altura y el ancho a la escena
            stage.setWidth(loginController.getGuardarAltura());
            stage.setHeight(loginController.getGuardarAncho());

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
