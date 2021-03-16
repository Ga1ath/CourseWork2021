package com.example.cinema_booking.dao_prototypes;

import org.json.JSONObject;
import java.util.ArrayList;


public interface TicketPrototype {

    static void add(int seatID,
                    int sessionID,
                    String customerID) {

    }

    static void delete(int id) {

    }

    static ArrayList<JSONObject> getAll() {
        return null;
    }

    static JSONObject findByID(int id) {
        return null;
    }

    static ArrayList<Integer> getAllBySessionID(int sessionID) {
        return null;
    }

    static ArrayList<Integer> getAllByCustomerID(String customerID) {
        return null;
    }

    static ArrayList<Integer> getAllByCustomerSessionID(String customerID, int sessionID) {
        return null;
    }
}