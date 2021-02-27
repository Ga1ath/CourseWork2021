package com.example.cinema_booking.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "\"Row\"")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"RowID\"")
    private int Row_ID;

    @Column(name = "\"SeatNumber\"")
    private byte SeatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`HallID`")
    private Hall HallID;

    public Row() {

    }

    public Row(byte seatNumber) {
        SeatNumber = seatNumber;
    }

    public int getRow_ID() {
        return Row_ID;
    }

    public byte getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(byte seatNumber) {
        SeatNumber = seatNumber;
    }

    public Hall getHallID() {
        return HallID;
    }

    public void setHallID(Hall hallID) {
        HallID = hallID;
    }
}
