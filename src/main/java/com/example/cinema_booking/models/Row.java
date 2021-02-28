package com.example.cinema_booking.models;

import javax.persistence.*;


@Entity
@Table (name = "\"Row\"")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"RowID\"")
    private int RowID;

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

    public Row(byte seatNumber, Hall hallID) {
        SeatNumber = seatNumber;
        HallID = hallID;
    }

    public int getRowID() {
        return RowID;
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
