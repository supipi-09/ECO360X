package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.routing.Routing_2;

import java.io.IOException;

public class CourseContentForm_1Controller {
    public AnchorPane context;
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();// create new stage
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
   /* Routing_2 r2 = new Routing_2();*/

    public void nextOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseContentForm_2");
    }
}
