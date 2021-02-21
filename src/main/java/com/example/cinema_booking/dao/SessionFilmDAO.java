package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.*;
import java.util.Collection;

public interface SessionFilmDAO {
    SessionFilm findByID(int id);
    void add(SessionFilm sessionFilm);
    void update(SessionFilm sessionFilm);
    void delete(SessionFilm sessionFilm);
    Collection<SessionFilm> getAll();
}
