package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginDashBordFormController {
    public AnchorPane contextB;
    public AnchorPane contex;

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
    public void profileOnAction(ActionEvent actionEvent) throws IOException {
        setUi2("ProfileForm");
    }
    
    private void setUi(String location) throws IOException {
        contextB.getChildren().clear();
        contextB.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
        );
    }
    private void setUi2(String location) throws IOException {
        Stage stage = (Stage) contex.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
