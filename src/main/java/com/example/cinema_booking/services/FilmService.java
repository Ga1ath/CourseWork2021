package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.FilmDAOimplementation;
import com.example.cinema_booking.models.Film;

import java.util.Collection;

public class FilmService {
    private final FilmDAOimplementation filmDAOimplementation = new FilmDAOimplementation();

    public FilmService() {

    }

    public void addFilm(Film film) {
        filmDAOimplementation.add(film);
    }

    public void updateFilm(Film film) {
        filmDAOimplementation.update(film);
    }

    public void deleteFilm(Film film) {
        filmDAOimplementation.delete(film);
    }

    public Collection<Film> getAllFilm() {
        return filmDAOimplementation.getAll();
    }

    public Film findByIdFilm(int id) {
        return filmDAOimplementation.findByID(id);
    }
}
