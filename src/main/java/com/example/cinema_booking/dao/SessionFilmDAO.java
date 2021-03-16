package com.example.cinema_booking.dao;

import com.example.cinema_booking.dao_prototypes.BaseDAO;
import com.example.cinema_booking.dao_prototypes.SessionFilmPrototype;
import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;


public class SessionFilmDAO extends BaseDAO implements SessionFilmPrototype {

    private static final Map<String, String> months = Map.ofEntries(
            Map.entry("01", "January"),
            Map.entry("02", "February"),
            Map.entry("03", "March"),
            Map.entry("04", "April"),
            Map.entry("05", "May"),
            Map.entry("06", "June"),
            Map.entry("07", "July"),
            Map.entry("08", "August"),
            Map.entry("09", "September"),
            Map.entry("10", "October"),
            Map.entry("11", "November"),
            Map.entry("12", "December")
    );

    public static void add(int hallID,
                           int filmIMDB,
                           short price,
                           String sessionTimeAndDate) {
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
                    "(\"HallID\", \"FilmIMDB\", \"Price\", \"DateAndTime\") " +
                    "values('" +
                    hallID + "', '" +
                    filmIMDB + "', '" +
                    price + "', '" +
                    sessionTimeAndDate + "');";
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
                        currentSessionFilm.put("hallID", resultSet.getInt("HallID"));
                        currentSessionFilm.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        currentSessionFilm.put("price", resultSet.getString("Price"));

                        String date_and_time = resultSet.getString("DateAndTime");
                        currentSessionFilm.put("sessionDate",
                                date_and_time.substring(8, 10) + "th " +
                                months.get(date_and_time.substring(7, 9)) + "" +
                                date_and_time.substring(0, 4)
                                );
                        currentSessionFilm.put("sessionTime", date_and_time.substring(11, 16));
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
                        result.put("hallID", resultSet.getInt("HallID"));
                        result.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        result.put("price", resultSet.getString("Price"));

                        String date_and_time = resultSet.getString("DateAndTime");
                        result.put("rawTime", date_and_time);
                        result.put("sessionDate",
                                date_and_time.substring(8, 10) + "th " +
                                        months.get(date_and_time.substring(7, 9)) + "" +
                                        date_and_time.substring(0, 4)
                        );
                        result.put("sessionTime", date_and_time.substring(11, 16));
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
                        currentSessionFilm.put("hallID", resultSet.getInt("HallID"));
                        currentSessionFilm.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        currentSessionFilm.put("price", resultSet.getString("Price"));

                        String date_and_time = resultSet.getString("DateAndTime");
                        currentSessionFilm.put("sessionDate",
                                date_and_time.substring(8, 10) + "th " +
                                        months.get(date_and_time.substring(7, 9)) + "" +
                                        date_and_time.substring(0, 4)
                        );
                        currentSessionFilm.put("sessionTime", date_and_time.substring(11, 16));
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
