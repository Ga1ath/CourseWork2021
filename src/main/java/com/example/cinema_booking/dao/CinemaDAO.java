package com.example.cinema_booking.dao;

import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class CinemaDAO {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "root";
    private static Connection connection;

    private static ResultSet executeQuery(Statement statement, String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException throwable) {
            System.out.println("Cannot execute query");
            throwable.printStackTrace();
            return null;
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwable) {
            System.out.println("Cannot close connection");
            throwable.printStackTrace();
        }
    }

    private static void openConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
    }

    public static void add(String address,
                           String publicName) {
        openConnection();
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException throwable) {
                System.out.println("Cannot create statement");
                throwable.printStackTrace();
                return;
            }

            String query = "insert into \"Cinema\"" +
                    "(\"Address\", \"PublicName\") " +
                    "values('" +
                    address + "', '" +
                    publicName + "');";
            executeQuery(statement, query);
            closeConnection();
        } else {
            System.out.println("Connection had not been opened");
        }
    }

    public static void delete(int id) {
        openConnection();
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException throwable) {
                System.out.println("Cannot create statement");
                throwable.printStackTrace();
                return;
            }

            String query = "delete from \"Cinema\" where \"CinemaID\"=" +
                    id + ";";
            executeQuery(statement, query);
            closeConnection();
        } else {
            System.out.println("Connection had not been opened");
        }
    }

    public static ArrayList<JSONObject> getAll() {
        openConnection();
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException throwable) {
                System.out.println("Cannot create statement");
                throwable.printStackTrace();
                return new ArrayList<>();
            }

            String query = "select * from \"Cinema\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentCinema = new JSONObject();
                        currentCinema.put("id", resultSet.getInt("CinemaID"));
                        currentCinema.put("address", resultSet.getString("Address"));
                        currentCinema.put("publicName", resultSet.getString("PublicName"));
                        result.add(currentCinema);
                    }
                } catch (SQLException throwable) {
                    System.out.println("Error while getting data from cursor");
                    throwable.printStackTrace();
                }
            }

            closeConnection();
            return result;
        } else {
            System.out.println("Connection had not been opened");
            return new ArrayList<>();
        }
    }

    public static JSONObject findByID(int id) {
        openConnection();
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException throwable) {
                System.out.println("Cannot create statement");
                throwable.printStackTrace();
                return new JSONObject();
            }

            String query = "select * from \"Cinema\" where \"CinemaID\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("id", resultSet.getInt("CinemaID"));
                        result.put("address", resultSet.getString("Address"));
                        result.put("publicName", resultSet.getString("PublicName"));
                    }
                } catch (SQLException throwable) {
                    System.out.println("Error while getting data from cursor");
                    throwable.printStackTrace();
                }
            }

            closeConnection();
            return result;
        } else {
            System.out.println("Connection had not been opened");
            return new JSONObject();
        }
    }
}
