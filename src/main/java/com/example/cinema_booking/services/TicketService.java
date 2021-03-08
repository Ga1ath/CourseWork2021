package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Ticket;
import com.example.cinema_booking.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketService() {

    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    public Iterable<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findByIdTicket(int id) {
        return ticketRepository.findById(id);
    }
}
