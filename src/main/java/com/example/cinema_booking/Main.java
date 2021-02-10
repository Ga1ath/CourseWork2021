package com.example.cinema_booking;

import com.example.cinema_booking.models.Film;
import com.example.cinema_booking.services.FilmService;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        FilmService filmService = new FilmService();
        Film film = new Film("film1", new Date(10000000), (short) 120, 100000000, "dddd", "xex", "url", "ddd");
        filmService.addFilm(film);
    }
}
