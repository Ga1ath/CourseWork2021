package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface TicketDAO {
    Ticket findByID(int id);
    void add(Ticket ticket);
    void update(Ticket ticket);
    void delete(Ticket ticket);
    Collection<Ticket> getAll();
}
