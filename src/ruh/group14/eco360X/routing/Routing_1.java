package ruh.group14.eco360X.routing;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Routing_1 {
    public void newWindowOnAction(String location) throws IOException {
        Stage stage = new Stage();
        URL resource = getClass().getResource("../view/"+location+".fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Eco360X");
        stage.show();
    }
}
