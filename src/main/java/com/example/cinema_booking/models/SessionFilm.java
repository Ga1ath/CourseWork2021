package com.example.cinema_booking.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "\"SessionFilm\"")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"SessionID\"")
    private int SessionID;

    @Column(name = "\"SessionTime\"")
    private Date SessionTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`HallID`")
    private Hall HallID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`FilmID`")
    private Film FilmID;

    public SessionFilm() {

    }

    public SessionFilm(Date sessionTime) {
        SessionTime = sessionTime;
    }

    public int getSessionID() {
        return SessionID;
    }

    public Date getSessionTime() {
        return SessionTime;
    }

    public void setSessionTime(Date sessionTime) {
        SessionTime = sessionTime;
    }

    public Hall getHallID() {
        return HallID;
    }

    public void setHallID(Hall hallID) {
        HallID = hallID;
    }

    public Film getFilmID() {
        return FilmID;
    }

    public void setFilmID(Film filmID) {
        FilmID = filmID;
    }
}
