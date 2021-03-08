package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
