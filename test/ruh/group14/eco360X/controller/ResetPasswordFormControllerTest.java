package ruh.group14.eco360X.controller;


import ruh.group14.eco360X.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ResetPasswordFormControllerTest {
    String selectedEmail ="";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new ResetPasswordFormControllerTest().changePasswordOnAction();
    }

    void changePasswordOnAction() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE email=?");
        preparedStatement.setString(1,"oshada@gmail.com");
        preparedStatement.executeUpdate();
    }
}