package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface CinemaDAO {
    Cinema findByID(int id);
    void add(Cinema cinema);
    void update(Cinema cinema);
    void delete(Cinema cinema);
    Collection<Cinema> getAll();
}
