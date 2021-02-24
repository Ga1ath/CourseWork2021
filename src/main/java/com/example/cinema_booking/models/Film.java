package com.example.cinema_booking.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "\"Film\"", schema = "public")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"FilmID\"")
    private int FilmID;

    @OneToMany(mappedBy = "FilmID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SessionFilm> FilmSessions;

    @Column(name = "\"FilmName\"")
    private String FilmName;

    @Column(name = "\"ReleaseDate\"")
    private Date ReleaseDate;

    @Column(name = "\"LengthOfFilm\"")
    private short LengthOfFilm;

    @Column(name = "\"Budget\"")
    private int Budget;

    @Column(name = "\"MainRoles\"")
    private String MainRoles;

    @Column(name = "\"Country\"")
    private String Country;

    @Column(name = "\"Logo\"")
    private String Logo;

    @Column(name = "\"Genre\"")
    private String Genre;

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Film() {

    }

    public Film(String filmName, Date releaseDate, short lengthOfFilm, int budget, String mainRoles, String country, String logo, String genre) {
        FilmName = filmName;
        ReleaseDate = releaseDate;
        LengthOfFilm = lengthOfFilm;
        Budget = budget;
        MainRoles = mainRoles;
        Country = country;
        Logo = logo;
        Genre = genre;
        FilmSessions = new ArrayList<>();
    }

    public int getFilmID() {
        return FilmID;
    }

    public String getFilmName() {
        return FilmName;
    }

    public void setFilmName(String filmName) {
        FilmName = filmName;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        ReleaseDate = releaseDate;
    }

    public short getLengthOfFilm() {
        return LengthOfFilm;
    }

    public void setLengthOfFilm(short lengthOfFilm) {
        LengthOfFilm = lengthOfFilm;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public String getMainRoles() {
        return MainRoles;
    }

    public void setMainRoles(String mainRoles) {
        MainRoles = mainRoles;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public List<SessionFilm> getFilmSessions() {
        return FilmSessions;
    }

    public void setFilmSessions(List<SessionFilm> filmSessions) {
        FilmSessions = filmSessions;
    }
}
