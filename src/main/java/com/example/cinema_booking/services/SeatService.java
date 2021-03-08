package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Seat;
import com.example.cinema_booking.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public SeatService() {

    }

    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    public void deleteSeat(Seat seat) {
        seatRepository.delete(seat);
    }

    public Iterable<Seat> getAllSeat() {
        return seatRepository.findAll();
    }

    public Optional<Seat> findByIdSeat(int id) {
        return seatRepository.findById(id);
    }
}
