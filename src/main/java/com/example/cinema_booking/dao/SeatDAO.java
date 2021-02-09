package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface SeatDAO {
    Seat findByID(int id);
    void add(Seat seat);
    void update(Seat seat);
    void delete(Seat seat);
    Collection<Seat> getAll();
}
