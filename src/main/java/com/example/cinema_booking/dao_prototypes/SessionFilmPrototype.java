package com.example.cinema_booking.dao_prototypes;

import org.json.JSONObject;
import java.util.ArrayList;


public interface SessionFilmPrototype {

    static void add(int hallID,
                    int filmIMDB,
                    short price,
                    String sessionTimeAndDate) {

    }

    static void delete(int id) {

    }

    static ArrayList<JSONObject> getAll() {
        return null;
    }

    static JSONObject findByID(int id) {
        return null;
    }

    static ArrayList<JSONObject> findAllWhereIDEqualFilmID(int filmID) {
        return null;
    }
}