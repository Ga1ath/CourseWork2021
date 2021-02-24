package com.example.cinema_booking.services;

import com.example.cinema_booking.dao.SessionFilmDAOimplementation;
import com.example.cinema_booking.models.SessionFilm;

import java.util.Collection;

public class SessionFilmService {
    private final SessionFilmDAOimplementation sessionFilmDAOimplementation = new SessionFilmDAOimplementation();

    public SessionFilmService() {

    }

    public void addSessionFilm(SessionFilm sessionFilm) {
        sessionFilmDAOimplementation.add(sessionFilm);
    }

    public void updateSessionFilm(SessionFilm sessionFilm) {
        sessionFilmDAOimplementation.update(sessionFilm);
    }

    public void deleteSessionFilm(SessionFilm sessionFilm) {
        sessionFilmDAOimplementation.delete(sessionFilm);
    }

    public Collection<SessionFilm> getAllSessionFilm() {
        return sessionFilmDAOimplementation.getAll();
    }

    public SessionFilm findByIdSessionFilm(int id) {
        return sessionFilmDAOimplementation.findByID(id);
    }
}
