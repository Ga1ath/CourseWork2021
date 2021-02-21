package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Cinema;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CinemaDAOimplementation implements CinemaDAO {
    private Session session = null;

    @Override
    public void add(Cinema cinema) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add cinema object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Cinema cinema) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update cinema object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Cinema cinema) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete cinema object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Cinema> getAll() {
        List<Cinema> cinemas = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            cinemas = (List<Cinema>)session.createQuery("From Cinema").list();
        } catch (Exception e) {
            System.out.println("Cannot get all cinema objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cinemas;
    }

    @Override
    public Cinema findByID(int id) {
        Cinema cinema = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            cinema = session.get(Cinema.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get cinema object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cinema;
    }
}
