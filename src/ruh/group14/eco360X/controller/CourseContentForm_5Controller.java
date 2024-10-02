package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseContentForm_5Controller {
    public AnchorPane context;

    public void previousOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseContentForm_4");
    }
    public void quizOnAction(ActionEvent actionEvent) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/home.fxml"));
            AnchorPane root = fxmlLoader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Home");

            // Set the scene
            newStage.setScene(new Scene(root));

            // Show the stage
            newStage.show();

            // Close the current stage
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();// create new stage
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
