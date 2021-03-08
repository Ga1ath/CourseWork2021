package com.example.cinema_booking;


import com.example.cinema_booking.models.Customer;
import com.example.cinema_booking.models.Film;
import com.example.cinema_booking.models.SessionFilm;
import com.example.cinema_booking.services.CustomerService;
import com.example.cinema_booking.services.FilmService;
import com.example.cinema_booking.services.SessionFilmService;
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

import java.util.*;


@RestController
public class InputController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private SessionFilmService sessionFilmService;

    @GetMapping(value = "/find")
    public ResponseEntity<HashMap<String, Object>> getOneFilm(
            @RequestParam(name = "filmName", defaultValue = "Avengers Infinity War")
                    String filmName
    ) throws UnirestException, JSONException {

        // checking existence film in DB
        Optional<Film> film = filmService.findByFilmNameFilm(filmName);
        if (film.isPresent()) {
            // creating HaspMap response to client
            HashMap<String, Object> response_to_client = new HashMap<>();
            response_to_client.put("ID", film.get().getFilmIMDB());
            response_to_client.put("Title", filmName);
            response_to_client.put("Genre", film.get().getGenre());
            response_to_client.put("Logo", film.get().getLogo());
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
        filmService.addFilm(new Film(
                film_title,
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
        ));

        return new ResponseEntity<>(response_to_client, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<ArrayList<HashMap<String, Object>>> getInfoAboutFilm() {
        ArrayList<Film> films = (ArrayList<Film>) filmService.getAllFilm();
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        for (Film film : films) {
            HashMap<String, Object> current  = new HashMap<>();
            current.put("id", film.getFilmIMDB());
            current.put("name", film.getFilmName());
            current.put("genre", film.getGenre());
            current.put("logo", film.getLogo());
            result.add(current);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signup(
            @RequestBody Map<String, String> userInfo
    ) {
        String loginName = userInfo.get("LoginName");
        if (customerService.findByIdCustomer(loginName).isPresent()) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this LoginName already exists");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        customerService.addCustomer(new Customer(
                userInfo.get("Email"),
                userInfo.get("FirstName"),
                userInfo.get("LastName"),
                loginName,
                passwordEncoder.encode(userInfo.get("Password"))));

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signin(
            @RequestBody Map<String, String> userInfo
    ) {
        String loginName = userInfo.get("LoginName");
        Optional<Customer> customer = customerService.findByIdCustomer(loginName);
        if (customer.isEmpty()) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this LoginName does not exist");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        if (!passwordEncoder.matches(userInfo.get("Password"),
                customer.get().getPasswordHash())) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Wrong password");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<HashMap<String, Object>>> getSessionsByFilm(
            @RequestParam(name = "filmID") Integer filmID
    ) {
        Optional<Film> film = filmService.findByIdFilm(filmID);
        if (film.isEmpty()) {
            ArrayList<HashMap<String, Object>> cause = new ArrayList<>();
            HashMap<String, Object> message = new HashMap<>();
            message.put("Cause", "Film with this ID does not exist");
            cause.add(message);
            return new ResponseEntity<>(cause, HttpStatus.NOT_FOUND);
        }

        List<SessionFilm> sessionFilms =
                sessionFilmService.findAllWhereIDEqualFilmID(filmID);

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        if (sessionFilms != null) {
            for (SessionFilm sessionFilm : sessionFilms) {
                HashMap<String, Object> currentSessionFilm = new HashMap<>();
                currentSessionFilm.put("SessionID", sessionFilm.getSessionID());
                currentSessionFilm.put("HallID", sessionFilm.getHallID());
                currentSessionFilm.put("FilmID", sessionFilm.getFilmIMDB());
                currentSessionFilm.put("SessionDate", sessionFilm.getSessionDate());
                currentSessionFilm.put("SessionTime", sessionFilm.getSessionTime());
                result.add(currentSessionFilm);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
