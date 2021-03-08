package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Customer;
import com.example.cinema_booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService() {

    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findByIdCustomer(String name) {
        return customerRepository.findById(name);
    }
}
