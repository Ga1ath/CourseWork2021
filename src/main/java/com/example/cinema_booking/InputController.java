package com.example.cinema_booking;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {

    @GetMapping
    public JSONObject getInfoAboutFilm(
            @RequestParam(name = "filmName", defaultValue = "Avengers Infinity War") String filmName) throws UnirestException {

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

        // creating JSON response to client
        JSONObject response_to_client = new JSONObject();
        response_to_client.put("ID", film_id);
        response_to_client.put("Title", film_title);
        response_to_client.put("Genre", film_genre);
        response_to_client.put("Logo", film_logo);

        return response_to_client;
    }
}
