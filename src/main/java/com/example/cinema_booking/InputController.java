package com.example.cinema_booking;


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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.*;


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
        String loginName = userInfo.get("LoginName");
        if (CustomerService.findByIDCustomer(loginName).length() > 0) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this LoginName already exists");
            return new ResponseEntity<>(cause, HttpStatus.CONFLICT);
        }

        CustomerService.addCustomer(
                userInfo.get("Email"),
                userInfo.get("FirstName"),
                userInfo.get("LastName"),
                loginName,
                passwordEncoder.encode(userInfo.get("Password")));

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> signin(
            @RequestBody Map<String, String> userInfo
    ) {
        String loginName = userInfo.get("LoginName");
        JSONObject customer = CustomerService.findByIDCustomer(loginName);
        if (customer.length() == 0) {
            HashMap<String, String> cause = new HashMap<>();
            cause.put("Cause", "Customer with this LoginName does not exist");
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
    public ResponseEntity<ArrayList<HashMap<String, Object>>> getSessionsByFilm(
            @RequestParam(name = "filmID") Integer filmID
    ) {
        JSONObject film = FilmService.findByIDFilm(filmID);
        if (film.length() == 0) {
            ArrayList<HashMap<String, Object>> cause = new ArrayList<>();
            HashMap<String, Object> message = new HashMap<>();
            message.put("Cause", "Film with this ID does not exist");
            cause.add(message);
            return new ResponseEntity<>(cause, HttpStatus.NOT_FOUND);
        }

        ArrayList<JSONObject> sessionFilms =
                SessionFilmService.findAllWhereIDEqualFilmID(filmID);

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        if (sessionFilms.size() > 0) {
            for (JSONObject sessionFilm : sessionFilms) {
                HashMap<String, Object> currentSessionFilm = new HashMap<>();
                currentSessionFilm.put("SessionID", sessionFilm.getInt("id"));
                currentSessionFilm.put("HallID", sessionFilm.getInt("hallID"));
                currentSessionFilm.put("FilmID", sessionFilm.getInt("filmIMDB"));
                currentSessionFilm.put("SessionDate", sessionFilm.getString("sessionDate"));
                currentSessionFilm.put("SessionTime", sessionFilm.getString("sessionTime"));
                result.add(currentSessionFilm);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
