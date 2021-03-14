package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.RowDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class RowService {

    public static void addRow(short seatNumber, int hallID, short numberInHall) {
        RowDAO.add(seatNumber, hallID, numberInHall);
    }

    public static void deleteRow(int id) {
        RowDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllRows() {
        return RowDAO.getAll();
    }

    public static JSONObject findByIDRow(int id) {
        return RowDAO.findByID(id);
    }

    public static ArrayList<JSONObject> getAllRowsByHallID(int hallID) {
        return RowDAO.getAllByHallID(hallID);
    }
}
