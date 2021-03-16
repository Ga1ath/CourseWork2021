package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.TicketDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class TicketService {

    public static void addTicket(int seatID, int sessionID, String customerID) {
        TicketDAO.add(seatID, sessionID, customerID);
    }

    public static void deleteTicket(int id) {
        TicketDAO.delete(id);
    }

    public static ArrayList<JSONObject> getAllTickets() {
        return TicketDAO.getAll();
    }

    public static JSONObject findByIDTicket(int id) {
        return TicketDAO.findByID(id);
    }

    public static ArrayList<Integer> getAllTicketsBySessionID(int sessionID) {
        return TicketDAO.getAllBySessionID(sessionID);
    }

    public static ArrayList<Integer> getAllTicketsByCustomerID(String customerID) {
        return TicketDAO.getAllByCustomerID(customerID);
    }

    public static ArrayList<Integer> getAllTicketsByCustomerSessionID(
            String customerID, int sessionID) {
        return TicketDAO.getAllByCustomerSessionID(customerID, sessionID);
    }
}
