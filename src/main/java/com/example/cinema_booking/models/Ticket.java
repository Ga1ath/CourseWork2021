package com.example.cinema_booking.models;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID")
    private int TicketID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SeatID")
    private Seat SeatID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SessionID")
    private SessionFilm SessionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    private Customer CustomerID;

    public Ticket() {

    }

    public Ticket(Seat seatID, SessionFilm sessionID, Customer customerID) {
        SeatID = seatID;
        SessionID = sessionID;
        CustomerID = customerID;
    }

    public int getTicketID() {
        return TicketID;
    }

    public Seat getSeatID() {
        return SeatID;
    }

    public SessionFilm getSessionID() {
        return SessionID;
    }

    public Customer getCustomerID() {
        return CustomerID;
    }
}
