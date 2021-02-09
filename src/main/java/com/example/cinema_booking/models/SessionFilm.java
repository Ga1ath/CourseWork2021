package com.example.cinema_booking.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "SessionFilm")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SessionID")
    private int SessionID;

    @OneToMany(mappedBy = "SessionID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> CustomerTickets;

    @Column(name = "SessionTime")
    private Date SessionTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HallID")
    private Hall HallID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FilmID")
    private Film FilmID;

    public SessionFilm() {

    }

    public SessionFilm(Date sessionTime, Film filmID, Hall hallID) {
        SessionTime = sessionTime;
        FilmID = filmID;
        HallID = hallID;
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

    public Film getFilmID() {
        return FilmID;
    }

    public Hall getHallID() {
        return HallID;
    }
}
