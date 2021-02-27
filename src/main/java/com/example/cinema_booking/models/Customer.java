package com.example.cinema_booking.models;

import javax.persistence.*;


@Entity
@Table (name = "\"Customer\"")
public class Customer {

    @Column(name = "\"Email\"")
    private String Email;

    @Column(name = "\"FirstName\"")
    private String FirstName;

    @Column(name = "\"LastName\"")
    private String LastName;

    @Id
    @Column(name = "\"LoginName\"")
    private String LoginName;

    @Column(name = "\"PasswordHash\"")
    private String PasswordHash;

    public Customer() {

    }

    public Customer(String email, String firstName, String lastName, String loginName, String passwordHash) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        LoginName = loginName;
        PasswordHash = passwordHash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }
}
