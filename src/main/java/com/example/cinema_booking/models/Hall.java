package com.example.cinema_booking.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HallID")
    private int HallID;

    @OneToMany(mappedBy = "HallID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hall> HallSessions;

    @Column(name = "RowsNumber")
    private byte RowsNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CinemaID")
    private Cinema CinemaID;

    @OneToMany(mappedBy = "HallID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hall> HallRows;

    public Hall() {

    }

    public Hall(byte rowsNumber) {
        RowsNumber = rowsNumber;
        HallRows = new ArrayList<>();
    }

    public int getHallID() {
        return HallID;
    }

    public int getRowsNumber() {
        return RowsNumber;
    }

    public void setRowsNumber(byte rowsNumber) {
        RowsNumber = rowsNumber;
    }

    public Cinema getCinemaID() {
        return CinemaID;
    }

    public void setCinemaID(Cinema cinemaID) {
        CinemaID = cinemaID;
    }

    public List<Hall> getHallRows() {
        return HallRows;
    }

    public void setHallRows(List<Hall> hallRows) {
        HallRows = hallRows;
    }
}
