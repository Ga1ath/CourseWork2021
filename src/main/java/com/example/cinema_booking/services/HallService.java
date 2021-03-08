package com.example.cinema_booking.services;

import com.example.cinema_booking.models.Hall;
import com.example.cinema_booking.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public HallService() {

    }

    public void addHall(Hall hall) {
        hallRepository.save(hall);
    }

    public void deleteHall(Hall hall) {
        hallRepository.delete(hall);
    }

    public Iterable<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    public Optional<Hall> findByIdHall(int id) {
        return hallRepository.findById(id);
    }
}
