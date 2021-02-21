package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface CustomerDAO {
    Customer findByID(int id);
    Customer findByLoginName(String loginName);
    Exception add(Customer customer);
    Exception update(Customer customer);
    Exception delete(Customer customer);
    Collection<Customer> getAll();
}
