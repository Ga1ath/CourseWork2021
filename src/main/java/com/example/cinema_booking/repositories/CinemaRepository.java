package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {

}
