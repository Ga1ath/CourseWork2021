package com.example.cinema_booking.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"SessionFilm\"")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"SessionID\"")
    private int SessionID;

    @OneToMany(mappedBy = "SessionID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> SessionTickets;

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
        SessionTickets = new ArrayList<>();
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

    public List<Ticket> getSessionTickets() {
        return SessionTickets;
    }

    public void setSessionTickets(List<Ticket> sessionTickets) {
        SessionTickets = sessionTickets;
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
