package com.example.cinema_booking.models;

import javax.persistence.*;


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

    public Cinema() {

    }

    public Cinema(String address, String publicName) {
        Address = address;
        PublicName = publicName;
    }

    public int getCinemaID() {
        return CinemaID;
    }

    public String getAddress() {
        return Address;
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
