package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.CustomerDAO;
import com.example.cinema_booking.dao.FilmDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class FilmService {

    public static void addFilm(String filmName, String releaseDate, String lengthOfFilm,
                        String mainRoles, String logo, String genre, int filmIMDB,
                        String releaseYear, String rated, String director, String plot) {
        FilmDAO.add(filmName, releaseDate, lengthOfFilm,
                mainRoles, logo, genre, filmIMDB, releaseYear, rated, director, plot);
    }

    public static void deleteFilm(int id) {
        FilmDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllFilms() {
        return FilmDAO.getAll();
    }

    public static JSONObject findByIDFilm(int id) {
        return FilmDAO.findByID(id);
    }

    public static JSONObject findByFilmNameFilm(String filmName) {
        return FilmDAO.findByFilmName(filmName);
    }
}
