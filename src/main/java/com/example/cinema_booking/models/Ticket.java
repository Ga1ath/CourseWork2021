package com.example.cinema_booking.models;

import javax.persistence.*;

@Entity
@Table(name = "\"Ticket\"")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TicketID\"")
    private int TicketID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`SeatID`")
    private Seat SeatID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`SessionID`")
    private SessionFilm SessionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`CustomerID`")
    private Customer CustomerID;

    public Ticket() {

    }

    public int getTicketID() {
        return TicketID;
    }

    public Seat getSeatID() {
        return SeatID;
    }

    public void setSeatID(Seat seatID) {
        SeatID = seatID;
    }

    public SessionFilm getSessionID() {
        return SessionID;
    }

    public void setSessionID(SessionFilm sessionID) {
        SessionID = sessionID;
    }

    public Customer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customer customerID) {
        CustomerID = customerID;
    }
}
