package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    public AnchorPane context;

    public void quizOnAction(ActionEvent actionEvent) throws IOException {
        openHome();
    }

    private void openHome() throws IOException {
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
        Stage currentStage = (Stage) context.getScene().getWindow();
        currentStage.close();
    }

    public void openFirstQuestion(ActionEvent actionEvent) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/firstquestion.fxml"));
            AnchorPane root = fxmlLoader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Question 01");

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

    public void openSecondQuestion(ActionEvent actionEvent) {


        try {

            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/secondquestion.fxml"));
            AnchorPane root = fxmlLoader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Question 02");

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

    public void openThirdQuestion(ActionEvent actionEvent) {


        try {

            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/thirdquestion.fxml"));
            AnchorPane root = fxmlLoader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Question 03");

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
    public void closeWindow(ActionEvent actionEvent) {
        // Get the current stage using the event source (the Finish button)
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        // Close the stage
        stage.close();
    }

}

