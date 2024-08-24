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
import ruh.group14.eco360X.db.UserSelect;
import ruh.group14.eco360X.model.User;
import ruh.group14.eco360X.util.Security.PasswordManager;

import java.io.IOException;
import java.sql.*;

import static java.lang.String.format;

public class LoginFormController {
    public AnchorPane stgLoginWindow;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void forgetPwdOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPasswordForm");
    }

    public void signUpPageOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();

        try {
            User selectedUser = new UserSelect().login(email);
            if (null != selectedUser) {
                if (new PasswordManager().checkPassword(password, selectedUser.getPassword())) {
                    setUi("LoginDashBordForm");
                    ProfileFormController.userEmail = selectedUser.getEmail();
                    new Alert(Alert.AlertType.INFORMATION, "Login Successful").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Wrong Password").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, String.format("%s not found", email)).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING, e.toString()).show();
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) stgLoginWindow.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
