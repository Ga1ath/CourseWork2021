package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface RowDAO {
    Row findByID(int id);
    void add(Row row);
    void update(Row row);
    void delete(Row row);
    Collection<Row> getAll();
}
