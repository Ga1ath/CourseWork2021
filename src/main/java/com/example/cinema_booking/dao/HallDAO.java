package com.example.cinema_booking.dao;

import com.example.cinema_booking.dao_prototypes.BaseDAO;
import com.example.cinema_booking.dao_prototypes.HallPrototype;
import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class HallDAO extends BaseDAO implements HallPrototype {

    public static void add(short rowsNumber,
                           int cinemaID,
                           String hallName) {
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

            String query = "insert into \"Hall\"" +
                    "(\"RowsNumber\", \"CinemaID\", \"HallName\") " +
                    "values('" +
                    rowsNumber + "', '" +
                    cinemaID + "', '" +
                    hallName + "');";
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

            String query = "delete from \"Hall\" where \"HallID\"=" +
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

            String query = "select * from \"Hall\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentHall = new JSONObject();
                        currentHall.put("id", resultSet.getInt("HallID"));
                        currentHall.put("rowsNumber", resultSet.getShort("RowsNumber"));
                        currentHall.put("cinemaID", resultSet.getInt("CinemaID"));
                        currentHall.put("hallName", resultSet.getString("HallName"));
                        result.add(currentHall);
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

            String query = "select * from \"Hall\" where \"HallID\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("id", resultSet.getInt("HallID"));
                        result.put("rowsNumber", resultSet.getShort("RowsNumber"));
                        result.put("cinemaID", resultSet.getInt("CinemaID"));
                        result.put("hallName", resultSet.getString("HallName"));
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
