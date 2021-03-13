package com.example.cinema_booking.dao;

import com.example.cinema_booking.dao_prototypes.BaseDAO;
import com.example.cinema_booking.dao_prototypes.SessionFilmPrototype;
import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class SessionFilmDAO extends BaseDAO implements SessionFilmPrototype {

    public static void add(String sessionDate,
                           int hallID,
                           int filmIMDB,
                           String sessionTime) {
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

            String query = "insert into \"SessionFilm\"" +
                    "(\"SessionDate\", \"HallID\", \"FilmIMDB\", \"SessionTime\") " +
                    "values('" +
                    sessionDate + "', '" +
                    hallID + "', '" +
                    filmIMDB + "', '" +
                    sessionTime + "');";
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

            String query = "delete from \"SessionFilm\" where \"SessionFilmID\"=" +
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

            String query = "select * from \"SessionFilm\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentSessionFilm = new JSONObject();
                        currentSessionFilm.put("id", resultSet.getInt("SessionID"));
                        currentSessionFilm.put("sessionDate", resultSet.getString("SessionDate"));
                        currentSessionFilm.put("hallID", resultSet.getInt("HallID"));
                        currentSessionFilm.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        currentSessionFilm.put("sessionTime", resultSet.getString("SessionTime"));
                        result.add(currentSessionFilm);
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

            String query = "select * from \"SessionFilm\" where \"SessionID\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("id", resultSet.getInt("SessionID"));
                        result.put("sessionDate", resultSet.getString("SessionDate"));
                        result.put("hallID", resultSet.getInt("HallID"));
                        result.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        result.put("sessionTime", resultSet.getString("SessionTime"));
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

    public static ArrayList<JSONObject> findAllWhereIDEqualFilmID(int filmID) {
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

            String query = "select * from \"SessionFilm\" where \"FilmIMDB\" = " + filmID + ";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentSessionFilm = new JSONObject();
                        currentSessionFilm.put("id", resultSet.getInt("SessionID"));
                        currentSessionFilm.put("sessionDate", resultSet.getString("SessionDate"));
                        currentSessionFilm.put("hallID", resultSet.getInt("HallID"));
                        currentSessionFilm.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        currentSessionFilm.put("sessionTime", resultSet.getString("SessionTime"));
                        result.add(currentSessionFilm);
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
}
