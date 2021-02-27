package com.example.cinema_booking.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table (name = "\"Film\"", schema = "public")
public class Film {

    @Column(name = "\"FilmName\"")
    private String FilmName;

    @Column(name = "\"ReleaseDate\"")
    private Date ReleaseDate;

    @Column(name = "\"LengthOfFilm\"")
    private short LengthOfFilm;

    @Column(name = "\"MainRoles\"")
    private String MainRoles;

    @Column(name = "\"Logo\"")
    private String Logo;

    @Column(name = "\"Genre\"")
    private String Genre;

    @Id
    @Column(name = "\"FilmIMDB\"")
    private String FilmIMDB;

    @Column(name = "\"ReleaseYear\"")
    private String ReleaseYear;

    @Column(name = "\"Rated\"")
    private String Rated;

    @Column(name = "\"Director\"")
    private String Director;

    @Column(name = "\"Plot\"")
    private String Plot;

    public Film() {

    }

    public Film(String filmName, Date releaseDate, short lengthOfFilm,
                String mainRoles, String logo, String genre, String filmIMDB,
                String releaseYear, String rated, String director, String plot) {
        FilmName = filmName;
        ReleaseDate = releaseDate;
        LengthOfFilm = lengthOfFilm;
        MainRoles = mainRoles;
        Logo = logo;
        Genre = genre;
        FilmIMDB = filmIMDB;
        ReleaseYear = releaseYear;
        Rated = rated;
        Director = director;
        Plot = plot;
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

    public String getMainRoles() {
        return MainRoles;
    }

    public void setMainRoles(String mainRoles) {
        MainRoles = mainRoles;
    }

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

    public String getFilmIMDB() {
        return FilmIMDB;
    }

    public void setFilmIMDB(String filmIMDB) {
        FilmIMDB = filmIMDB;
    }

    public String getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        ReleaseYear = releaseYear;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }
}
