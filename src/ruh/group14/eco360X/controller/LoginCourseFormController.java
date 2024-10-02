package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import ruh.group14.eco360X.routing.Routing_1;

import java.io.IOException;

public class LoginCourseFormController {
    Routing_1 w1=new Routing_1();

    public void startNow_1_OnAction(ActionEvent actionEvent) throws IOException {
        w1.newWindowOnAction("CourseContentForm_1");
    }

    public void startNow_4_OnAction(ActionEvent actionEvent) throws IOException {
        new Alert(Alert.AlertType.INFORMATION,"Available soon...").show();
    }

    public void startNow_3_OnAction(ActionEvent actionEvent) throws IOException {
        new Alert(Alert.AlertType.INFORMATION,"Available soon...").show();
    }

    public void startNow_2_OnAction(ActionEvent actionEvent) throws IOException {
        new Alert(Alert.AlertType.INFORMATION,"Available soon...").show();
    }
}
