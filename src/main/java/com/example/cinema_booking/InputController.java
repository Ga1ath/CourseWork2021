package com.example.cinema_booking;


import com.example.cinema_booking.services.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.IntStream;


@RestController
public class InputController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = "/find")
    public ResponseEntity<HashMap<String, Object>> getOneFilm(
            @RequestParam(name = "filmName", defaultValue = "Avengers Infinity War")
                    String filmName
    ) throws UnirestException, JSONException {

        // checking existence film in DB
        JSONObject film = FilmService.findByFilmNameFilm(filmName);
        System.out.println(film);
        if (film.length() > 0) {
            // creating HaspMap response to client
            HashMap<String, Object> response_to_client = new HashMap<>();
            response_to_client.put("id", film.getInt("filmIMDB"));
            response_to_client.put("name", film.getString("filmName"));
            response_to_client.put("genre", film.getString("genre"));
            response_to_client.put("logo", film.getString("logo"));
            return new ResponseEntity<>(response_to_client, HttpStatus.OK);
        }

        String filmNameHTTP = filmName.replaceAll("\\s+", "%20");
        // getting basic info about film by name (+ film ID in IMDB)
        HttpResponse<String> response = Unirest
                .get("https://imdb8.p.rapidapi.com/title/auto-complete?q=" + filmNameHTTP)
                .header("x-rapidapi-key", "f3e55c08ddmsh1a3452690bf39ecp1c7681jsnd926d8c78dde")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .asString();

        // extracting info about film as JSON object
        JSONObject info_about_film = new JSONObject(response.getBody());

        // getting logo, ID
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
        HashMap<String, Object> response_to_client = new HashMap<>();
        response_to_client.put("ID", Integer.parseInt(film_id.substring(2)));
        response_to_client.put("Title", film_title);
        response_to_client.put("Genre", film_genre);
        response_to_client.put("Logo", film_logo);

        // Adding film to DB
        FilmService.addFilm(film_title,
                full_info_about_film.getString("Released"),
                full_info_about_film.getString("Runtime"),
                full_info_about_film.getString("Actors"),
                film_logo,
                film_genre,
                Integer.parseInt(film_id.substring(2)),
                full_info_about_film.getString("Year"),
                full_info_about_film.getString("Rated"),
                full_info_about_film.getString("Director"),
                full_info_about_film.getString("Plot")
        );

        return new ResponseEntity<>(response_to_client, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<ArrayList<HashMap<String, Object>>> getInfoAboutAllFilms() {
        ArrayList<JSONObject> films = FilmService.getAllFilms();
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        for (JSONObject film : films) {
            HashMap<String, Object> current  = new HashMap<>();
            current.put("id", film.getInt("filmIMDB"));
            current.put("name", film.getString("filmName"));
            current.put("genre", film.getString("genre"));
            current.put("logo", film.getString("logo"));
            result.add(current);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signup(
            @RequestBody Map<String, String> userInfo
    ) {
        String email = userInfo.get("Email");
        if (CustomerService.findByIDCustomer(email).length() > 0) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this Email already exists");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        CustomerService.addCustomer(
                userInfo.get("Email"),
                userInfo.get("FirstName"),
                userInfo.get("LastName"),
                email,
                passwordEncoder.encode(userInfo.get("Password")));

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signin(
            @RequestBody Map<String, String> userInfo
    ) {
        String email = userInfo.get("Email");
        JSONObject customer = CustomerService.findByIDCustomer(email);
        if (customer.length() == 0) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this Email does not exist");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        if (!passwordEncoder.matches(userInfo.get("Password"),
                customer.getString("passwordHash"))) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Wrong password");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getSessionsByFilm(
            @RequestParam(name = "filmID") Integer filmID
    ) {
        JSONObject film = FilmService.findByIDFilm(filmID);
        if (film.length() == 0) {
            HashMap<String, Object> cause = new HashMap<>();
            cause.put("Cause", "Film with this ID does not exist");
            return new ResponseEntity<>(cause, HttpStatus.NOT_FOUND);
        }

        ArrayList<JSONObject> sessionFilms =
                SessionFilmService.findAllWhereIDEqualFilmID(filmID);
        HashMap<String, Object> result = new HashMap<>();

        result.put("filmName", film.getString("filmName"));
        result.put("length", film.getString("lengthOfFilm"));
        result.put("mainRoles", film.getString("mainRoles"));
        result.put("logo", film.getString("logo"));
        result.put("rated", film.getString("rated"));
        result.put("director", film.getString("director"));
        result.put("plot", film.getString("plot"));

        ArrayList<HashMap<String, Object>> sessions = new ArrayList<>();
        if (sessionFilms.size() > 0) {
            for (JSONObject sessionFilm : sessionFilms) {
                HashMap<String, Object> currentSessionFilm = new HashMap<>();
                currentSessionFilm.put("id", sessionFilm.getInt("id"));
                currentSessionFilm.put("date", sessionFilm.getString("sessionDate"));
                currentSessionFilm.put("time", sessionFilm.getString("sessionTime"));
                currentSessionFilm.put("price", sessionFilm.getInt("price"));
                sessions.add(currentSessionFilm);
            }
        }

        result.put("sessions", sessions);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<ArrayList<HashMap<String, Object>>>> getSeatsFromSession(
        @RequestParam(name = "sessionID") Integer sessionID
    ) {
        JSONObject session = SessionFilmService.findByIDSessionFilm(sessionID);
        ArrayList<ArrayList<HashMap<String, Object>>> response = new ArrayList<>();

        if (session.length() == 0) {
            response.add(new ArrayList<>());
            HashMap<String, Object> cause = new HashMap<>();
            cause.put("Cause", "Session with this sessionID does not exist");
            response.get(0).add(cause);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        int hallID = session.getInt("hallID");
        int[] session_tickets =
                TicketService.getAllTicketsBySessionID(sessionID).
                        stream().
                        mapToInt(x -> x).
                        toArray();
        ArrayList<JSONObject> rows_in_session = RowService.getAllRowsByHallID(hallID);

        for (JSONObject row : rows_in_session) {
            ArrayList<HashMap<String, Object>> current_row = new ArrayList<>();
            int rowID = row.getInt("id");
            ArrayList<JSONObject> seats_in_row = SeatService.getAllSeatsByRowID(rowID);

            for (JSONObject seat : seats_in_row) {
                HashMap<String, Object> current_seat = new HashMap<>();
                current_seat.put("name", seat.getString("seatName"));
                if (IntStream.of(session_tickets).anyMatch(
                        x -> x == seat.getInt("id"))) {
                    current_seat.put("isBooked", true);
                } else {
                    current_seat.put("isBooked", false);
                }
                current_row.add(current_seat);
            }
            response.add(current_row);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getInfoAboutCustomer(
            @RequestParam(name = "email") String email
    ) {
        JSONObject customer = CustomerService.findByIDCustomer(email);
        HashMap<String, Object> response = new HashMap<>();

        if (customer.length() == 0) {
            response.put("Cause", "Customer with this email does not exist");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("firstName", customer.getString("firstName"));
        response.put("lastName", customer.getString("lastName"));

        ArrayList<Integer> customer_sessions = TicketService.getAllTicketsByCustomerID(email);
        TreeMap<Long, JSONObject> tickets_chronological = new TreeMap<>(Collections.reverseOrder());

        for (int sessionID : customer_sessions) {
            JSONObject session = SessionFilmService.findByIDSessionFilm(sessionID);

            long session_time = Timestamp.valueOf(session.getString("rawTime")).getTime();
            JSONObject film = FilmService.findByIDFilm(session.getInt("filmIMDB"));

            ArrayList<Integer> seats = TicketService.getAllTicketsByCustomerSessionID(
                    email, session.getInt("id")
            );

            JSONObject info = new JSONObject();

            info.put("filmName", film.getString("filmName"));
            info.put("logo", film.getString("logo"));
            info.put("price", session.getInt("price") * seats.size());
            info.put("hallName",
                    HallService.findByIDHall(session.getInt("hallID")).
                            getString("hallName"));

            ArrayList<String> seats_names = new ArrayList<>();
            for (int seat : seats) {
                seats_names.add(SeatService.findByIDSeat(seat).getString("seatName"));
            }
            info.put("seatName", seats_names);

            tickets_chronological.put(session_time, info);
        }

        ArrayList<Map<String, Object>> tickets = new ArrayList<>();
        for (JSONObject ticket : tickets_chronological.values()) {
            JSONArray seats = (JSONArray) ticket.get("seatName");
            StringBuilder seats_as_string = new StringBuilder();
            int len = seats.length();
            for (int i = 0; i < len; i++) {
                seats_as_string.append(seats.getString(i));
                if (i < len - 1) {
                    seats_as_string.append(", ");
                }
            }
            tickets.add(Map.of(
                    "filmName", ticket.getString("filmName"),
                    "logo", ticket.getString("logo"),
                    "price", ticket.getInt("price"),
                    "hallName", ticket.getString("hallName"),
                    "seatName", seats_as_string
            ));
        }
        response.put("tickets", tickets);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
