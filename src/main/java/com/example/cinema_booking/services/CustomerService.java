package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.CustomerDAOimplementation;
import com.example.cinema_booking.models.Customer;

import java.util.Collection;

public class CustomerService {
    private final CustomerDAOimplementation customerDAOimplementation = new CustomerDAOimplementation();

    public CustomerService() {

    }

    public void addCustomer(Customer customer) {
        customerDAOimplementation.add(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDAOimplementation.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDAOimplementation.delete(customer);
    }

    public Collection<Customer> getAllCustomer() {
        return customerDAOimplementation.getAll();
    }

    public Customer findByIdCustomer(int id) {
        return customerDAOimplementation.findByID(id);
    }
}
