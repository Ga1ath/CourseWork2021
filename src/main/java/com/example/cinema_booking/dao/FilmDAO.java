package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface FilmDAO {
    Film findByID(int id);
    Film findByName(String name);
    void add(Film film);
    void update(Film film);
    void delete(Film film);
    Collection<Film> getAll();
}
