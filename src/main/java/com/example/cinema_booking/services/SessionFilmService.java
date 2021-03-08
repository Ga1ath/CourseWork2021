package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Film;
import com.example.cinema_booking.models.SessionFilm;
import com.example.cinema_booking.repositories.SessionFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SessionFilmService {

    @Autowired
    private SessionFilmRepository sessionFilmRepository;

    @Autowired
    private FilmService filmService;

    public SessionFilmService() {

    }

    public void addSessionFilm(SessionFilm sessionFilm) {
        sessionFilmRepository.save(sessionFilm);
    }

    public void deleteSessionFilm(SessionFilm sessionFilm) {
        sessionFilmRepository.delete(sessionFilm);
    }

    public Iterable<SessionFilm> getAllSessionFilm() {
        return sessionFilmRepository.findAll();
    }

    public Optional<SessionFilm> findByIdSessionFilm(int id) {
        return sessionFilmRepository.findById(id);
    }

    public List<SessionFilm> findAllWhereIDEqualFilmID(int filmID) {
        return sessionFilmRepository.findByFilmID(filmID);
    }
}
