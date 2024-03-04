package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CoursesFormController {
    private void newWindowOnAction(String location) throws IOException {
        Stage stage = new Stage();
        URL resource = getClass().getResource("../view/"+location+".fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }

    public void startNow_1_OnAction(ActionEvent actionEvent) throws IOException {
        newWindowOnAction("CourseContentForm_1");
    }
}
