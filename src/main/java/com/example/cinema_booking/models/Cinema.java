package com.example.cinema_booking.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "\"Cinema\"")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"CinemaID\"")
    private int CinemaID;

    @Column(name = "\"Address\"")
    private String Address;

    @Column(name = "\"PublicName\"")
    private String PublicName;

    @OneToMany(mappedBy = "CinemaID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hall> CinemaHalls;

    public Cinema() {

    }

    public Cinema(String address, String publicName) {
        Address = address;
        PublicName = publicName;
        CinemaHalls = new ArrayList<>();
    }

    public int getCinemaID() {
        return CinemaID;
    }

    public String getAddress() {
        return Address;
    }

    public List<Hall> getCinemaHalls() {
        return CinemaHalls;
    }

    public void setCinemaHalls(List<Hall> cinemaHalls) {
        CinemaHalls = cinemaHalls;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPublicName() {
        return PublicName;
    }

    public void setPublicName(String publicName) {
        PublicName = publicName;
    }


}
