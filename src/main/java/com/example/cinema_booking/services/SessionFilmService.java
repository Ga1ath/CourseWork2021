package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.SessionFilmDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class SessionFilmService {

    public static void addSessionFilm(String sessionDate, int hallID,
                                      int filmID, String sessionTime) {
        SessionFilmDAO.add(sessionDate, hallID, filmID, sessionTime);
    }

    public static void deleteSessionFilm(int id) {
        SessionFilmDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllSessionFilms() {
        return SessionFilmDAO.getAll();
    }

    public static JSONObject findByIDSessionFilm(int id) {
        return SessionFilmDAO.findByID(id);
    }

    public static ArrayList<JSONObject> findAllWhereIDEqualFilmID(int filmID) {
        return SessionFilmDAO.findAllWhereIDEqualFilmID(filmID);
    }
}
