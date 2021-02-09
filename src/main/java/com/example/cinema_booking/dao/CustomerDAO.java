package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface CustomerDAO {
    Customer findByID(int id);
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    Collection<Customer> getAll();
}
