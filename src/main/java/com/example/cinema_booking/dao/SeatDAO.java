package com.example.cinema_booking.dao;

import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class SeatDAO {

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

    public static void add(int rowID,
                           String seatName) {
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

            String query = "insert into \"Seat\"" +
                    "(\"RowID\", \"IsOccupied\", \"SeatName\") " +
                    "values('" +
                    rowID + "', '" +
                    false + "', '" +
                    seatName + "');";
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

            String query = "delete from \"Seat\" where \"SeatID\"=" +
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

            String query = "select * from \"Seat\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentSeat = new JSONObject();
                        currentSeat.put("id", resultSet.getInt("SeatID"));
                        currentSeat.put("rowID", resultSet.getString("RowID"));
                        currentSeat.put("isOccupied", resultSet.getString("IsOccupied"));
                        currentSeat.put("seatName", resultSet.getString("SeatName"));
                        result.add(currentSeat);
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

            String query = "select * from \"Seat\" where \"SeatID\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("id", resultSet.getInt("SeatID"));
                        result.put("rowID", resultSet.getString("RowID"));
                        result.put("isOccupied", resultSet.getString("IsOccupied"));
                        result.put("seatName", resultSet.getString("SeatName"));
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
