package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.SeatDAOimplementation;
import com.example.cinema_booking.models.Seat;

import java.util.Collection;

public class SeatService {
    private final SeatDAOimplementation seatDAOimplementation = new SeatDAOimplementation();

    public SeatService() {

    }

    public void addSeat(Seat seat) {
        seatDAOimplementation.add(seat);
    }

    public void updateSeat(Seat seat) {
        seatDAOimplementation.update(seat);
    }

    public void deleteSeat(Seat seat) {
        seatDAOimplementation.delete(seat);
    }

    public Collection<Seat> getAllSeat() {
        return seatDAOimplementation.getAll();
    }

    public Seat findByIdSeat(int id) {
        return seatDAOimplementation.findByID(id);
    }
}
