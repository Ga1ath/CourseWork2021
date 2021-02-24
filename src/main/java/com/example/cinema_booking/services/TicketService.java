package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.TicketDAOimplementation;
import com.example.cinema_booking.models.Ticket;

import java.util.Collection;

public class TicketService {
    private final TicketDAOimplementation ticketDAOimplementation = new TicketDAOimplementation();

    public TicketService() {

    }

    public void addTicket(Ticket ticket) {
        ticketDAOimplementation.add(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketDAOimplementation.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDAOimplementation.delete(ticket);
    }

    public Collection<Ticket> getAllTicket() {
        return ticketDAOimplementation.getAll();
    }

    public Ticket findByIdTicket(int id) {
        return ticketDAOimplementation.findByID(id);
    }
}
