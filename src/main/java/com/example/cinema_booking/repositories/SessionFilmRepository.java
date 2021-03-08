package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Film;
import com.example.cinema_booking.models.SessionFilm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionFilmRepository extends CrudRepository<SessionFilm, Integer> {
    List<SessionFilm> findByFilmID(int filmID);
}
