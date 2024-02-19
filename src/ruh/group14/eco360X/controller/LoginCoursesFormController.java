package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginCoursesFormController {
    public AnchorPane context;

    public void startNow_1_OnAction(ActionEvent actionEvent) throws IOException {
        setUi("Corse_1Form");
    }

    public void startNow_2_OnAction(ActionEvent actionEvent) throws IOException {
        setUi("Corse_2Form");
    }

    public void startNow_3_OnAction(ActionEvent actionEvent) throws IOException {
        setUi("Corse_3Form");
    }

    public void startNow_4_OnAction(ActionEvent actionEvent) throws IOException {
        setUi("Corse_4Form");
    }

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
        );
    }
}
