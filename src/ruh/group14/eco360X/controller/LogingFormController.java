package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogingFormController {
    public AnchorPane stgLoginWindow;
    public TextField txtUserName;
    public PasswordField pwdField;

    public void forgetPwdOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgetPaswordForm");
    }

    public void signUpPageOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginDashBordForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) stgLoginWindow.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
