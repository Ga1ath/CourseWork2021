package com.example.cinema_booking.dao_prototypes;

import org.json.JSONObject;
import java.util.ArrayList;


public interface RowPrototype {

    static void add(short seatNumber,
                    int hallID,
                    short numberInHall) {

    }

    static void delete(int id) {

    }

    static ArrayList<JSONObject> getAll() {
        return null;
    }

    static JSONObject findByID(int id) {
        return null;
    }

    static ArrayList<JSONObject> getAllByHallID(int hallID) {
        return null;
    }
}