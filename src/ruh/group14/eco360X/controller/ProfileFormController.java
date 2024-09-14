package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.db.Database;
import ruh.group14.eco360X.db.UserSelect;
import ruh.group14.eco360X.model.User;

import java.io.IOException;
import java.sql.*;

public class ProfileFormController {
    public AnchorPane context;
    public Label lblEmail;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAddress;
    public Label lblNic;
    public static String userEmail;

    public void initialize() {
        try {
            User user = new UserSelect().login(userEmail);
            lblAddress.setText(user.getAddress());
            lblEmail.setText(user.getEmail());
            lblNic.setText(user.getNic());
            lblFirstName.setText(user.getFirstName());
            lblLastName.setText(user.getLasttName());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    private void SetUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    public void loginOutAction(ActionEvent actionEvent) throws IOException {
        SetUi("DashBordForm");
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SetUi("LoginDashBordForm");
    }
}
