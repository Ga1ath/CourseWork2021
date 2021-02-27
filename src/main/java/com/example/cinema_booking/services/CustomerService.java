package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.CustomerDAOimplementation;
import com.example.cinema_booking.models.Customer;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class CustomerService {
    private final CustomerDAOimplementation customerDAOimplementation = new CustomerDAOimplementation();

    public CustomerService() {

    }

    public Exception addCustomer(Customer customer) {
        return customerDAOimplementation.add(customer);
    }

    public Exception updateCustomer(Customer customer) {
        return customerDAOimplementation.update(customer);
    }

    public Exception deleteCustomer(Customer customer) {
        return customerDAOimplementation.delete(customer);
    }

    public Collection<Customer> getAllCustomer() {
        return customerDAOimplementation.getAll();
    }

    public Customer findByIdCustomer(String id) {
        return customerDAOimplementation.findByID(id);
    }
}
