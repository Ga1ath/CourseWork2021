package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Cinema;
import com.example.cinema_booking.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public CinemaService() {

    }

    public void addCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    public void deleteCinema(Cinema cinema) {
        cinemaRepository.delete(cinema);
    }

    public Iterable<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    public Optional<Cinema> findByIdCinema(int id) {
        return cinemaRepository.findById(id);
    }
}
