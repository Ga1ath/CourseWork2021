package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
    Optional<Film> findByFilmName(String filmName);
}
