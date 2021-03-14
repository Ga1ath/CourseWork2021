package com.example.cinema_booking.dao_prototypes;

import org.json.JSONObject;
import java.util.ArrayList;


public interface SeatPrototype {

    static void add(int rowID,
                    String seatName) {

    }

    static void delete(int id) {

    }

    static ArrayList<JSONObject> getAll() {
        return null;
    }

    static JSONObject findByID(int id) {
        return null;
    }

    static ArrayList<JSONObject> getAllByRowID(int rowID) {
        return null;
    }
}