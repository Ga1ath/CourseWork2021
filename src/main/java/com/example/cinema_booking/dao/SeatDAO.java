package com.example.cinema_booking.dao;

import com.example.cinema_booking.dao_prototypes.BaseDAO;
import com.example.cinema_booking.dao_prototypes.SeatPrototype;
import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;


public class SeatDAO extends BaseDAO implements SeatPrototype {

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
                    "(\"RowID\", \"SeatName\") " +
                    "values('" +
                    rowID + "', '" +
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

    public static ArrayList<JSONObject> getAllByRowID(int rowID) {
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

            String query = "select (\"SeatID\", \"SeatName\") from \"Seat\" " +
                    "where \"RowID\" = " + rowID + ";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    // ResultSetMetaData meta_data = resultSet.getMetaData();
                    while (resultSet.next()) {
//                        int column_num = meta_data.getColumnCount();
//                        System.out.print("Column number: ");
//                        System.out.println(column_num);
//                        for (int i = 1; i <= column_num; i++) {
//                            System.out.print("i column type: ");
//                            System.out.println(meta_data.getColumnType(i));
//                            System.out.print("i column name: ");
//                            System.out.println(meta_data.getColumnName(i));
//                            System.out.print("i column value");
//                            System.out.println(resultSet.getObject("row"));
//                        }

                        String current_data =
                                new JSONObject(resultSet.getObject("row"))
                                        .getString("value");
                        int comma_position = current_data.indexOf(',');

                        JSONObject currentSeat = new JSONObject();
                        currentSeat.put("id",
                                current_data.substring(1, comma_position));
                        currentSeat.put("seatName",
                                current_data.substring(comma_position + 1, current_data.length() - 1));
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
}
