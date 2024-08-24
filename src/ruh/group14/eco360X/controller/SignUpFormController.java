package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.model.User;
import ruh.group14.eco360X.util.Security.PasswordManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        String password = new PasswordManager().encrypt(txtPassword.getText().trim());

        User createUser = new User(firstName, lastName, address, nic, email, password);

        try {
            boolean isSaved = signUp(createUser);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Welcome!").show();
                setUi("LoginForm");
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    private boolean signUp(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/wildCourse_lms", "root", "1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getNic());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLasttName());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getAddress());
        preparedStatement.setString(6, user.getPassword());
        int rowCount = preparedStatement.executeUpdate();

        return rowCount > 0;
    }

}
