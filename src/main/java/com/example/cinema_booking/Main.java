package com.example.cinema_booking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Main {
    public static void main(String[] args) throws UnirestException {
//        HttpResponse<String> response = Unirest.get("https://imdb8.p.rapidapi.com/title/auto-complete?q=avengersinfinitywar")
//                .header("x-rapidapi-key", "f3e55c08ddmsh1a3452690bf39ecp1c7681jsnd926d8c78dde")
//                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
//                .asString();
////        System.out.print("\n\n\n");
////        System.out.println(response.getBody());
////        System.out.println(response.getStatus());
////        System.out.println(response.getStatusText());
////        System.out.println(response.getHeaders());
////        System.out.println(response.getRawBody());
//
//        JSONObject info_about_film = new JSONObject(response.getBody());
//        String film_title = info_about_film.getJSONArray("d").getJSONObject(0).
//                getString("l");
//        String film_logo = info_about_film.getJSONArray("d").getJSONObject(0).
//                getJSONObject("i").getString("imageUrl");
//        String film_id = info_about_film.getJSONArray("d").getJSONObject(0).
//                getString("id");
//
//
//        // get full info
//
//        String address = "http://www.omdbapi.com/?i=" + film_id +
//                "&apikey=5e4a1184";
//        HttpResponse<String> response_total = Unirest.get(address).asString();
//        System.out.print("\n\n\n");
//        System.out.println(response_total.getBody());
////        System.out.println(response.getStatus());
////        System.out.println(response.getStatusText());
////        System.out.println(response.getHeaders());
////        System.out.println(response.getRawBody());
//
//        JSONObject full_info_about_film = new JSONObject(response_total.getBody());
//        String film_genre = full_info_about_film.getString("Genre");
//
//        JSONObject response_to_client = new JSONObject();
//        response_to_client.put("ID", film_id);
//        response_to_client.put("Title", film_title);
//        response_to_client.put("Genre", film_genre);
//        response_to_client.put("Logo", film_logo);


    }
}
