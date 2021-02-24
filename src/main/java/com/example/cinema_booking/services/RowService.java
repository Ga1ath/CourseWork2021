package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.RowDAOimplementation;
import com.example.cinema_booking.models.Row;

import java.util.Collection;

public class RowService {
    private final RowDAOimplementation rowDAOimplementation = new RowDAOimplementation();

    public RowService() {

    }

    public void addRow(Row row) {
        rowDAOimplementation.add(row);
    }

    public void updateRow(Row row) {
        rowDAOimplementation.update(row);
    }

    public void deleteRow(Row row) {
        rowDAOimplementation.delete(row);
    }

    public Collection<Row> getAllRow() {
        return rowDAOimplementation.getAll();
    }

    public Row findByIdRow(int id) {
        return rowDAOimplementation.findByID(id);
    }
}
