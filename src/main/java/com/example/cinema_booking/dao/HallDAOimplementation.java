package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Hall;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HallDAOimplementation implements HallDAO {
    private Session session = null;

    @Override
    public void add(Hall hall) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(hall);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add hall object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Hall hall) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(hall);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update hall object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Hall hall) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(hall);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete hall object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Hall> getAll() {
        List<Hall> halls = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            halls = (List<Hall>)session.createQuery("From Hall").list();
        } catch (Exception e) {
            System.out.println("Cannot get all hall objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return halls;
    }

    @Override
    public Hall findByID(int id) {
        Hall hall = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            hall = session.get(Hall.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get hall object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return hall;
    }
}
