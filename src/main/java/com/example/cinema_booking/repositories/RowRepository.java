package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Row;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends CrudRepository<Row, Integer> {
}
