package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.model.User;

import java.io.IOException;

public class ProfileFormControlledr {


    public AnchorPane context;
    public Label lblEmail;

    private void setData(){
        User user = new User();
        String txtEmail= user.getEmail();
        lblEmail.setText(txtEmail);
    }

    private void SetUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    public void loginOutAction(ActionEvent actionEvent) throws IOException {
        SetUi("DashBordForm");
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SetUi("LoginDashBordForm");
    }
}
