package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.SeatDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class SeatService {

    public static void addSeat(int rowID, String seatName) {
        SeatDAO.add(rowID, seatName);
    }

    public static void deleteSeat(int id) {
        SeatDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllSeats() {
        return SeatDAO.getAll();
    }

    public static JSONObject findByIDSeat(int id) {
        return SeatDAO.findByID(id);
    }

    public static ArrayList<JSONObject> getAllSeatsByRowID(int rowID) {
        return SeatDAO.getAllByRowID(rowID);
    }
}
