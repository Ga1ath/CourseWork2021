package com.example.cinema_booking.util;

import com.example.cinema_booking.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {

    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Cinema.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(Hall.class);
                configuration.addAnnotatedClass(Row.class);
                configuration.addAnnotatedClass(Seat.class);
                configuration.addAnnotatedClass(SessionFilm.class);
                configuration.addAnnotatedClass(Ticket.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Cannot create new session" + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
