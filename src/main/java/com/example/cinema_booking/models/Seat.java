package com.example.cinema_booking.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "\"Seat\"")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"SeatID\"")
    private int SeatID;

    @OneToMany(mappedBy = "SeatID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> SeatTickets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`RowID`")
    private Row RowID;

    public Seat() {
        SeatTickets = new ArrayList<>();
    }

    public int getSeatID() {
        return SeatID;
    }

    public Row getRowID() {
        return RowID;
    }

    public void setRowID(Row rowID) {
        RowID = rowID;
    }

    public List<Ticket> getSeatTickets() {
        return SeatTickets;
    }

    public void setSeatTickets(List<Ticket> seatTickets) {
        SeatTickets = seatTickets;
    }
}
