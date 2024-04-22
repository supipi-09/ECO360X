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

        for (User user : Database.userTable) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    setUi("LoginDashBordForm");

                    ProfileFormControlledr.loginEmail =email;

                   new Alert(Alert.AlertType.CONFIRMATION,
                           "You are Successfully login to the system!").show();
                    return;
                } else {
                    new Alert(Alert.AlertType.WARNING,
                            "Wrong Password or Email").show();
                    return;
                }
            }
        }
        new Alert(Alert.AlertType.WARNING,
                "Wrong Password or Email").show();
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) stgLoginWindow.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

}
