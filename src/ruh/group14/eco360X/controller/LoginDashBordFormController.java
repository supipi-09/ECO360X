package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginDashBordFormController {
    public AnchorPane contextB;

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginHomeForm");
    }

    public void coursesOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginCoursesForm");
    }

    public void aboutUsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginAboutUsForm");
    }

    public void contactUsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginContactUsForm");
    }
    
    private void setUi(String location) throws IOException {
        contextB.getChildren().clear();
        contextB.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
        );
    }
    private void setUi2(){

    }
    public void profileOnAction(ActionEvent actionEvent) {
    }
}
