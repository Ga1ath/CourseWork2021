package com.example.cinema_booking.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private int CustomerID;

    @OneToMany(mappedBy = "CustomerID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> CustomerTickets;

    @Column(name = "Email")
    private String Email;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    public Customer() {

    }

    public Customer(String email, String firstName, String lastName) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
    }

    public int getCustomerID() {
        return CustomerID;
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
}
