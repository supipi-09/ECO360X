package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileFormControlledr {

    public AnchorPane contex;

    private void SetUi(String location) throws IOException {
        Stage stage = (Stage) contex.getScene().getWindow();
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
