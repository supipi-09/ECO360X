package ruh.group14.eco360X.db;

import ruh.group14.eco360X.model.User;

import java.sql.*;

public class UserSelect {
    public User login(String email) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            User user = new User(
                    resultSet.getString("fName"),
                    resultSet.getString("lName"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("email"),
                    resultSet.getString(6)
            );
            return user;
        }
        return null;
    }
}
