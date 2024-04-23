package ruh.group14.eco360X.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LoginDashBordFormController {
    public AnchorPane context;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane contextB;

    public void initialize() {
        setData();
    }

    private void setData() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String txtDate = dateFormat.format(date);
        lblDate.setText(txtDate);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        e -> {
                            DateTimeFormatter dateFormatter =
                                    DateTimeFormatter.ofPattern("hh:mm:ss");
                            lblTime.setText(LocalTime.now().format(dateFormatter));
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

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
        setUiB("ContactUsForm");
    }

    public void profileOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ProfileForm");
    }


    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();// create new stage
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    private void setUiB(String location) throws IOException {
        contextB.getChildren().clear(); // navigate code
        contextB.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))
        );
    }

}
