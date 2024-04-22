package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContactUsController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtPhone;
    public TextArea txtMessage;

    public void submitOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION,
                "Hello"+" "+txtName.getText()+" "+"We got your massage.").show();
    }
}
