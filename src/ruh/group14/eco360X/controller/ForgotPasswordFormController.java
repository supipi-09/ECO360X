package ruh.group14.eco360X.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ruh.group14.eco360X.db.DbConnection;
import ruh.group14.eco360X.util.tools.VerificationCodeGenerator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ForgotPasswordFormController {
    public TextField txtEmail;
    public AnchorPane context;

    public void sendCodeOnAction(ActionEvent actionEvent) throws MessagingException, SQLException, ClassNotFoundException {
        /* System.out.println(new VerificationCodeGenerator().getCode(5));*/
        try {
            String fromEmail = "janithraditha@gmail.com";
            String toEmail = txtEmail.getText();
            String host = "localhost";
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            preparedStatement.setString(1,toEmail);
            if(preparedStatement.executeQuery().next()){
                int verificationCode = new VerificationCodeGenerator().getCode(5);

                Properties properties = System.getProperties();
                properties.setProperty("mail.smtp.host", host);

                Session session = Session.getDefaultInstance(properties);

                MimeMessage mimeMessage = new MimeMessage(session);
                mimeMessage.setFrom(new InternetAddress(fromEmail));
                mimeMessage.setSubject("Verification Code");
                mimeMessage.setText("Verification Code:" + verificationCode);
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

                //Transport.send(mimeMessage);
                System.out.println("completed");

                FXMLLoader fxmlLoader =
                        new FXMLLoader(getClass().getResource("../view/CodeVerificationForm.fxml"));
                Parent parent = fxmlLoader.load();
                CodeVerificationFormController controller = fxmlLoader.getController();
                controller.setUserData(verificationCode, txtEmail.getText());
                Stage stage = (Stage) context.getScene().getWindow();
                stage.setScene(new Scene(parent));
            }else {
                new Alert(Alert.AlertType.ERROR, "This email not found").show();
            }

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

    }

    public void backToLoginForm(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
