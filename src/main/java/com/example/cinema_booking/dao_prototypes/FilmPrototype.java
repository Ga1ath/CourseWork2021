package com.example.cinema_booking.dao_prototypes;

import org.json.JSONObject;
import java.util.ArrayList;


public interface FilmPrototype {

    static void add(String filmName,
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

    }

    static void delete(int id) {

    }

    static ArrayList<JSONObject> getAll() {
        return null;
    }

    static JSONObject findByID(int id) {
        return null;
    }

    static JSONObject findByFilmName(String filmName) {
        return null;
    }
}