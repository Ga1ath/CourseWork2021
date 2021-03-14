package com.example.cinema_booking.dao_prototypes;

import org.json.JSONObject;
import java.util.ArrayList;


public interface HallPrototype {

    static void add(short rowsNumber,
                    int cinemaID,
                    String hallName) {

    }

    static void delete(int id) {

    }

    static ArrayList<JSONObject> getAll() {
        return null;
    }

    static JSONObject findByID(int id) {
        return null;
    }
}