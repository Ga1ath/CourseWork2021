package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.HallDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class HallService {

    public static void addHall(short rowsNumber, int cinemaID, String hallName) {
        HallDAO.add(rowsNumber, cinemaID, hallName);
    }

    public static void deleteHall(int id) {
        HallDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllHalls() {
        return HallDAO.getAll();
    }

    public static JSONObject findByIDHall(int id) {
        return HallDAO.findByID(id);
    }
}
