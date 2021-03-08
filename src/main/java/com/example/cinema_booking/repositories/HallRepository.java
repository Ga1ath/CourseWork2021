package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends CrudRepository<Hall, Integer> {
}
