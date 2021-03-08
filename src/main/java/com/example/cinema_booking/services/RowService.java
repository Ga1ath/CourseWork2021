package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Row;
import com.example.cinema_booking.repositories.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class RowService {

    @Autowired
    private RowRepository rowRepository;

    public RowService() {

    }

    public void addRow(Row row) {
        rowRepository.save(row);
    }

    public void deleteRow(Row row) {
        rowRepository.delete(row);
    }

    public Iterable<Row> getAllRow() {
        return rowRepository.findAll();
    }

    public Optional<Row> findByIdRow(int id) {
        return rowRepository.findById(id);
    }
}
