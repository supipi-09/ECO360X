package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.db.Database;
import ruh.group14.eco360X.model.User;

import java.io.IOException;

public class ProfileFormControlledr {


    public AnchorPane context;
    public Label lblEmail;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAddress;
    public Label lblNic;

    public void initialize(){setData();}
    public static String loginEmail="";

    private void setData(){
        for(User tmp : Database.userTable){
            if(tmp.getEmail().equals(loginEmail)){
                lblFirstName.setText(tmp.getFirstName());
                lblLastName.setText(tmp.getLasttName());
                lblAddress.setText(tmp.getAddress());
                lblNic.setText(tmp.getNic());
                lblEmail.setText(tmp.getEmail());
            }
        }
    }

    private void SetUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    public void loginOutAction(ActionEvent actionEvent) throws IOException {
        SetUi("DashBordForm");
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SetUi("LoginDashBordForm");
    }
}
