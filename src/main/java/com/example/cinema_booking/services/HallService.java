package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.HallDAOimplementation;
import com.example.cinema_booking.models.Hall;

import java.util.Collection;

public class HallService {
    private final HallDAOimplementation hallDAOimplementation = new HallDAOimplementation();

    public HallService() {

    }

    public void addHall(Hall hall) {
        hallDAOimplementation.add(hall);
    }

    public void updateHall(Hall hall) {
        hallDAOimplementation.update(hall);
    }

    public void deleteHall(Hall hall) {
        hallDAOimplementation.delete(hall);
    }

    public Collection<Hall> getAllHall() {
        return hallDAOimplementation.getAll();
    }

    public Hall findByIdHall(int id) {
        return hallDAOimplementation.findByID(id);
    }
}
