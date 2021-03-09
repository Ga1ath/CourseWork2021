package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.CinemaDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class CinemaService {

    public static void addCinema(String address, String publicName) {
        CinemaDAO.add(address, publicName);
    }

    public static void deleteCinema(int id) {
        CinemaDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllCinemas() {
        return CinemaDAO.getAll();
    }

    public static JSONObject findByIDCinema(int id) {
        return CinemaDAO.findByID(id);
    }
}
