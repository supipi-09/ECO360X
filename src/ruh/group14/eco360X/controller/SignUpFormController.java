package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.db.Database;
import ruh.group14.eco360X.model.User;

import java.io.IOException;

public class SignUpFormController {
    public AnchorPane context;
    public PasswordField txtPassword;
    public TextField txtLastName;
    public TextField txtFirstName;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtNic;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();
        String password = txtPassword.getText().trim();//depaththa spaces ayn karanwa

        Database.userTable.add(
                new User(firstName, lastName, address, nic, email, password)
        );
        new Alert(Alert.AlertType.CONFIRMATION, "Welcome" + " " +
                firstName + " " + lastName + " " + "Congrats Your Signup Successful!").show();
        setUi("LoginForm");

    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

}
