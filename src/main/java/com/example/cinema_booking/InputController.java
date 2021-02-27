package com.example.cinema_booking;


import com.example.cinema_booking.models.Customer;
import com.example.cinema_booking.services.CustomerService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class InputController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<HashMap<String, String>> getInfoAboutFilm(
            @RequestParam(name = "filmName", defaultValue = "AvengersInfinityWar") String filmName
    ) throws UnirestException, JSONException {

        // getting basic info about film by name (+ film ID in IMDB)
        HttpResponse<String> response = Unirest.get("https://imdb8.p.rapidapi.com/title/auto-complete?q=" + filmName)
                .header("x-rapidapi-key", "f3e55c08ddmsh1a3452690bf39ecp1c7681jsnd926d8c78dde")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .asString();

        // extracting info about film as JSON object
        JSONObject info_about_film = new JSONObject(response.getBody());

        // getting title, logo, ID
        String film_title = info_about_film.getJSONArray("d").getJSONObject(0).
                getString("l");
        String film_logo = info_about_film.getJSONArray("d").getJSONObject(0).
                getJSONObject("i").getString("imageUrl");
        String film_id = info_about_film.getJSONArray("d").getJSONObject(0).
                getString("id");

        // getting full info about film
        String address = "http://www.omdbapi.com/?i=" + film_id +
                "&apikey=5e4a1184";
        HttpResponse<String> response_total = Unirest.get(address).asString();

        // creating JSON object that will be contain all necessary info about film
        JSONObject full_info_about_film = new JSONObject(response_total.getBody());

        // getting genre
        String film_genre = full_info_about_film.getString("Genre");

        // creating HaspMap response to client
        HashMap<String, String> response_to_client = new HashMap<>();
        response_to_client.put("ID", film_id);
        response_to_client.put("Title", film_title);
        response_to_client.put("Genre", film_genre);
        response_to_client.put("Logo", film_logo);

        return new ResponseEntity<>(response_to_client, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signup(
            @RequestBody Map<String, String> userInfo
    ) {
        String loginName = userInfo.get("LoginName");
        if (customerService.findByIdCustomer(loginName) != null) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this LoginName already exists");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        Exception error = customerService.addCustomer(new Customer(
                userInfo.get("Email"),
                userInfo.get("FirstName"),
                userInfo.get("LastName"),
                loginName,
                passwordEncoder.encode(userInfo.get("Password"))));
        if (error != null) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", error.getMessage());
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signin(
            @RequestBody Map<String, String> userInfo
    ) {
        String loginName = userInfo.get("LoginName");
        Customer customer = customerService.findByIdCustomer(loginName);
        if (customer == null) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this LoginName does not exist");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        if (!passwordEncoder.matches(userInfo.get("Password"), customer.getPasswordHash())) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Wrong password");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

}
