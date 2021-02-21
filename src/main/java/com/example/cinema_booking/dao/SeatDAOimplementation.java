package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Seat;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SeatDAOimplementation implements SeatDAO {
    private Session session = null;

    @Override
    public void add(Seat seat) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(seat);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add seat object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Seat seat) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(seat);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update seat object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Seat seat) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(seat);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete seat object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Seat> getAll() {
        List<Seat> seats = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            seats = (List<Seat>)session.createQuery("From Seat").list();
        } catch (Exception e) {
            System.out.println("Cannot get all seat objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return seats;
    }

    @Override
    public Seat findByID(int id) {
        Seat seat = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            seat = session.get(Seat.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get seat object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return seat;
    }
}
