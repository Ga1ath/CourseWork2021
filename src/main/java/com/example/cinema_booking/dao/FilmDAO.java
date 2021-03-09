package com.example.cinema_booking.dao;

import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class FilmDAO {

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

    public static void add(String filmName,
                           String releaseDate,
                           String lengthOfFilm,
                           String mainRoles,
                           String logo,
                           String genre,
                           int filmIMDB,
                           String releaseYear,
                           String rated,
                           String director,
                           String plot) {
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

            String query = "insert into \"Film\"" +
                    "(\"FilmName\", \"ReleaseDate\", \"LengthOfFilm\", \"MainRoles\", " +
                    "\"Logo\", \"Genre\", \"FilmIMDB\", \"ReleaseYear\", " +
                    "\"Rated\", \"Director\", \"Plot\") " +
                    "values('" +
                    filmName + "', '" +
                    releaseDate + "', '" +
                    lengthOfFilm + "', '" +
                    mainRoles + "', '" +
                    logo + "', '" +
                    genre + "', '" +
                    filmIMDB + "', '" +
                    releaseYear + "', '" +
                    rated + "', '" +
                    director + "', '" +
                    plot + "');";
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

            String query = "delete from \"Film\" where \"FilmID\"=" +
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

            String query = "select * from \"Film\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentFilm = new JSONObject();
                        currentFilm.put("filmName", resultSet.getString("FilmName"));
                        currentFilm.put("releaseDate", resultSet.getString("ReleaseDate"));
                        currentFilm.put("lengthOfFilm", resultSet.getString("LengthOfFilm"));
                        currentFilm.put("mainRoles", resultSet.getString("MainRoles"));
                        currentFilm.put("logo", resultSet.getString("Logo"));
                        currentFilm.put("genre", resultSet.getString("Genre"));
                        currentFilm.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        currentFilm.put("releaseYear", resultSet.getString("ReleaseYear"));
                        currentFilm.put("rated", resultSet.getString("Rated"));
                        currentFilm.put("director", resultSet.getString("Director"));
                        currentFilm.put("plot", resultSet.getString("Plot"));
                        result.add(currentFilm);
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

            String query = "select * from \"Film\" where \"FilmIMDB\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("filmName", resultSet.getString("FilmName"));
                        result.put("releaseDate", resultSet.getString("ReleaseDate"));
                        result.put("lengthOfFilm", resultSet.getString("LengthOfFilm"));
                        result.put("mainRoles", resultSet.getString("MainRoles"));
                        result.put("logo", resultSet.getString("Logo"));
                        result.put("genre", resultSet.getString("Genre"));
                        result.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        result.put("releaseYear", resultSet.getString("ReleaseYear"));
                        result.put("rated", resultSet.getString("Rated"));
                        result.put("director", resultSet.getString("Director"));
                        result.put("plot", resultSet.getString("Plot"));
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

    public static JSONObject findByFilmName(String filmName) {
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

            String query = "select * from \"Film\" where \"FilmName\"='" + filmName + "';";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("filmName", resultSet.getString("FilmName"));
                        result.put("releaseDate", resultSet.getString("ReleaseDate"));
                        result.put("lengthOfFilm", resultSet.getString("LengthOfFilm"));
                        result.put("mainRoles", resultSet.getString("MainRoles"));
                        result.put("logo", resultSet.getString("Logo"));
                        result.put("genre", resultSet.getString("Genre"));
                        result.put("filmIMDB", resultSet.getInt("FilmIMDB"));
                        result.put("releaseYear", resultSet.getString("ReleaseYear"));
                        result.put("rated", resultSet.getString("Rated"));
                        result.put("director", resultSet.getString("Director"));
                        result.put("plot", resultSet.getString("Plot"));
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
