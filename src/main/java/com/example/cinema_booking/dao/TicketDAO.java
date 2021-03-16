package com.example.cinema_booking.dao;

import com.example.cinema_booking.dao_prototypes.BaseDAO;
import com.example.cinema_booking.dao_prototypes.TicketPrototype;
import org.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.ArrayList;


public class TicketDAO extends BaseDAO implements TicketPrototype {

    public static void add(int seatID,
                           int sessionID,
                           String customerID) {
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

            String query = "insert into \"Ticket\"" +
                    "(\"SeatID\", \"SessionID\", \"CustomerID\") " +
                    "values('" +
                    seatID + "', '" +
                    sessionID + "', '" +
                    customerID + "');";
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

            String query = "delete from \"Ticket\" where \"TicketID\"=" +
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

            String query = "select * from \"Ticket\";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<JSONObject> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        JSONObject currentTicket = new JSONObject();
                        currentTicket.put("id", resultSet.getInt("TicketID"));
                        currentTicket.put("seatID", resultSet.getInt("SeatID"));
                        currentTicket.put("sessionID", resultSet.getInt("SessionID"));
                        currentTicket.put("customerID", resultSet.getString("CustomerID"));
                        result.add(currentTicket);
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

            String query = "select * from \"Ticket\" where \"TicketID\"=" + id + ";";
            ResultSet resultSet = executeQuery(statement, query);

            JSONObject result = new JSONObject();
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        result.put("id", resultSet.getInt("TicketID"));
                        result.put("seatID", resultSet.getInt("SeatID"));
                        result.put("sessionID", resultSet.getInt("SessionID"));
                        result.put("customerID", resultSet.getString("CustomerID"));
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

    public static ArrayList<Integer> getAllBySessionID(int sessionID) {
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

            String query = "select (\"SeatID\") from \"Ticket\" where \"SessionID\"=" + sessionID + ";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<Integer> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        result.add(resultSet.getInt("SeatID"));
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

    public static ArrayList<Integer> getAllByCustomerID(String customerID) {
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

            String query = "select (\"SessionID\") from \"Ticket\" where \"CustomerID\"='" + customerID + "';";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<Integer> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        result.add(resultSet.getInt("SessionID"));
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

    public static ArrayList<Integer> getAllByCustomerSessionID(String customerID, int sessionID) {
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

            String query = "select (\"SeatID\") from \"Ticket\" where" +
                    " \"CustomerID\"='" + customerID + "' and " +
                    " \"SessionID\"=" + sessionID + ";";
            ResultSet resultSet = executeQuery(statement, query);

            ArrayList<Integer> result = new ArrayList<>();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        result.add(resultSet.getInt("SeatID"));
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
