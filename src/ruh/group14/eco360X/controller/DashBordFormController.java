package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBordFormController {
    public AnchorPane context;//id'
    public AnchorPane contextB;//id

    public void homeOnAction(ActionEvent actionEvent) throws IOException {//method
        setUiB("HomeForm");
    }

    public void coursesOnAction(ActionEvent actionEvent) throws IOException {
       setUiB("CoursesForm");
    }

    public void aboutUsOnAction(ActionEvent actionEvent) throws IOException {
        setUiB("AboutUsForm");
    }

    public void contactUsOnAction(ActionEvent actionEvent) throws IOException {
        setUiB("ContactUsForm" +
                "");
    }

    public void loginSignupOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LogingForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();// create new stage
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    private  void setUiB(String location) throws IOException{
        contextB.getChildren().clear(); // navigate code
        contextB.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
        );
    }

}
