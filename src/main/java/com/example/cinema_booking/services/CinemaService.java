package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.CinemaDAOimplementation;
import com.example.cinema_booking.models.Cinema;

import java.util.Collection;

public class CinemaService {
    private final CinemaDAOimplementation cinemaDAOimplementation = new CinemaDAOimplementation();

    public CinemaService() {

    }

    public void addCinema(Cinema cinema) {
        cinemaDAOimplementation.add(cinema);
    }

    public void updateCinema(Cinema cinema) {
        cinemaDAOimplementation.update(cinema);
    }

    public void deleteCinema(Cinema cinema) {
        cinemaDAOimplementation.delete(cinema);
    }

    public Collection<Cinema> getAllCinema() {
        return cinemaDAOimplementation.getAll();
    }

    public Cinema findByIdCinema(int id) {
        return cinemaDAOimplementation.findByID(id);
    }
}
