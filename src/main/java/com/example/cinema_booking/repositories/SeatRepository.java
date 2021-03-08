package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {
}
