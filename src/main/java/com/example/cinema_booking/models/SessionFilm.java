package com.example.cinema_booking.models;

import javax.persistence.*;


@Entity
@Table(name = "\"SessionFilm\"")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"SessionID\"")
    private Integer SessionID;

    @Column(name = "\"SessionTime\"")
    private String SessionTime;

    @Column(name = "\"SessionDate\"")
    private String SessionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`HallID`")
    private Hall HallID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`FilmIMDB`")
    private Film FilmIMDB;

    public SessionFilm() {

    }

    public SessionFilm(String sessionTime, String sessionDate) {
        SessionTime = sessionTime;
        SessionDate = sessionDate;
    }

    public SessionFilm(String sessionTime, String sessionDate, Hall hallID, Film filmIMDB) {
        SessionTime = sessionTime;
        SessionDate = sessionDate;
        HallID = hallID;
        FilmIMDB = filmIMDB;
    }

    public Integer getSessionID() {
        return SessionID;
    }

    public String getSessionTime() {
        return SessionTime;
    }

    public void setSessionTime(String sessionTime) {
        SessionTime = sessionTime;
    }

    public String getSessionDate() {
        return SessionDate;
    }

    public void setSessionDate(String sessionDate) {
        SessionDate = sessionDate;
    }

    public Hall getHallID() {
        return HallID;
    }

    public void setHallID(Hall hallID) {
        HallID = hallID;
    }

    public Film getFilmIMDB() {
        return FilmIMDB;
    }

    public void setFilmIMDB(Film filmIMDB) {
        FilmIMDB = filmIMDB;
    }
}
