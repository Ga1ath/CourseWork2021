package com.example.cinema_booking.services;


import com.example.cinema_booking.dao.CustomerDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class CustomerService {

    public static void addCustomer(String email, String firstName, String lastName,
                                   String loginName, String passwordHash) {
        CustomerDAO.add(email, firstName, lastName, loginName, passwordHash);
    }

    public static void deleteCustomer(String loginName) {
        CustomerDAO.delete(loginName);
    }

    public static ArrayList<JSONObject> getAllCustomers() {
        return CustomerDAO.getAll();
    }

    public static JSONObject findByIDCustomer(String loginName) {
        return CustomerDAO.findByID(loginName);
    }
}
