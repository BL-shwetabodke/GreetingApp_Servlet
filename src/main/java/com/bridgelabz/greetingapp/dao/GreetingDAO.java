package com.bridgelabz.greetingapp.dao;

import com.bridgelabz.greetingapp.model.Greeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GreetingDAO {

    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/GreetingAppDB";
    private final static String DATABASE_USERNAME = "root";
    private final static String DATABASE_PASSWORD = "root";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean createGreeting(Greeting greeting) {
        String sqlQuery = "insert into Greetings (greeting_message) values (?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, greeting.greetingMessage);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> findAllGreetings() {
        List<String> greetings = new ArrayList<>();
        String sqlQuery = "select * from Greetings";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String greetingMessage = resultSet.getString(2);
                greetings.add(greetingMessage);
            }
            preparedStatement.close();
            return greetings;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
