package com.example.cinema_booking.models;

import javax.persistence.*;


@Entity
@Table (name = "\"Film\"", schema = "public")
public class Film {

    @Column(name = "\"FilmName\"")
    private String filmName;

    @Column(name = "\"ReleaseDate\"")
    private String ReleaseDate;

    @Column(name = "\"LengthOfFilm\"")
    private String LengthOfFilm;

    @Column(name = "\"MainRoles\"")
    private String MainRoles;

    @Column(name = "\"Logo\"")
    private String Logo;

    @Column(name = "\"Genre\"")
    private String Genre;

    @Id
    @Column(name = "\"FilmIMDB\"")
    private Integer FilmIMDB;

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

    public Film(String filmName, String releaseDate, String lengthOfFilm,
                String mainRoles, String logo, String genre, Integer filmIMDB,
                String releaseYear, String rated, String director, String plot) {
        this.filmName = filmName;
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
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getLengthOfFilm() {
        return LengthOfFilm;
    }

    public void setLengthOfFilm(String lengthOfFilm) {
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

    public Integer getFilmIMDB() {
        return FilmIMDB;
    }

    public void setFilmIMDB(Integer filmIMDB) {
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
