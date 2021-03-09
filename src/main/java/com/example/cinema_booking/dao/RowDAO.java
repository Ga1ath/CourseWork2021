package com.example.cinema_booking.dao;

import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class RowDAO {

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

    public static void add(short seatNumber,
                           int hallID) {
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

            String query = "insert into \"Row\"" +
                    "(\"SeatNumber\", \"HallID\") " +
                    "values('" +
                    seatNumber + "', '" +
                    hallID + "');";
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

            String query = "delete from \"Row\" where \"RowID\"=" +
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

            String query = "select * from \"Row\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentRow = new JSONObject();
                        currentRow.put("id", resultSet.getInt("RowID"));
                        currentRow.put("seatNumber", resultSet.getShort("SeatNumber"));
                        currentRow.put("hallID", resultSet.getInt("HallID"));
                        result.add(currentRow);
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

            String query = "select * from \"Row\" where \"RowID\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("id", resultSet.getInt("RowID"));
                        result.put("seatNumber", resultSet.getShort("SeatNumber"));
                        result.put("hallID", resultSet.getInt("HallID"));
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
