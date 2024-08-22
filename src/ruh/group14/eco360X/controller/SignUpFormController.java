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
        String password = txtPassword.getText().trim();//depaththa spaces ayn karanwa

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
                DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1234");
        String sql = "INSERT INTO users VALUES ('"+user.getNic()+"','"+user.getFirstName()+"'," +
                "'"+user.getLasttName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getAddress()+"')";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        /*preparedStatement.setString(1, user.getNic());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLasttName());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getPassword());
        preparedStatement.setString(6, user.getAddress());*/
        int rowCount =preparedStatement.executeUpdate(sql);

        return rowCount>0;
    }

}
