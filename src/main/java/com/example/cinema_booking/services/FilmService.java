package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Film;
import com.example.cinema_booking.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public FilmService() {

    }

    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    public void deleteFilm(Film film) {
        filmRepository.delete(film);
    }

    public Iterable<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    public Optional<Film> findByIdFilm(int id) {
        return filmRepository.findById(id);
    }

    public Optional<Film> findByFilmNameFilm(String filmName) {
        return filmRepository.findByFilmName(filmName);
    }
}
