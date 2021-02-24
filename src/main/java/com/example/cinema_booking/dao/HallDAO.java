package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface HallDAO {
    Hall findByID(int id);
    void add(Hall hall);
    void update(Hall hall);
    void delete(Hall hall);
    Collection<Hall> getAll();
}
