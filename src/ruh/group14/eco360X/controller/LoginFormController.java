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
            User selectedUser = login(email);
            if (null != selectedUser) {
                if (new PasswordManager().checkPassword(password, selectedUser.getPassword())) {
                    setUi("LoginDashBordForm");
                    Database.userTable.add(selectedUser);
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

    private User login(String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/wildCourse_lms", "root", "1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            User user = new User(
                    resultSet.getString("fName"),
                    resultSet.getString("lName"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("email"),
                    resultSet.getString(6)
            );
            return user;
        }
        return null;
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) stgLoginWindow.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
