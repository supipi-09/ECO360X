package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.db.Database;
import ruh.group14.eco360X.db.DbConnection;
import ruh.group14.eco360X.model.User;
import ruh.group14.eco360X.util.Security.PasswordManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ResetPasswordFormController {
    public PasswordField txtPassword;
    public AnchorPane context;

    String selectedEmail = "";

    public void setUserData(String email) {
        selectedEmail = email;
    }

    public void changePasswordOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        String newPw = new PasswordManager().encrypt(txtPassword.getText().trim());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET password=? WHERE email=?");
        preparedStatement.setString(1,newPw);
        preparedStatement.setString(2,selectedEmail);
        preparedStatement.executeUpdate();
        setUi("LoginForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
