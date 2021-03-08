package com.example.cinema_booking.repositories;

import com.example.cinema_booking.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
