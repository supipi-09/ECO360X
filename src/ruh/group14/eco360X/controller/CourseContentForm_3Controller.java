package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseContentForm_3Controller {
    public AnchorPane context;

    public void nextOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseContentForm_4");
    }

    public void previousOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseContentForm_2");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();// create new stage
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
