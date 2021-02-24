package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.SessionFilm;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SessionFilmDAOimplementation implements SessionFilmDAO {
    private Session session = null;

    @Override
    public void add(SessionFilm sessionFilm) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sessionFilm);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add sessionFilm object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(SessionFilm sessionFilm) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sessionFilm);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update sessionFilm object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(SessionFilm sessionFilm) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sessionFilm);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete sessionFilm object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<SessionFilm> getAll() {
        List<SessionFilm> sessionFilms = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            sessionFilms = (List<SessionFilm>)session.createQuery("From SessionFilm").list();
        } catch (Exception e) {
            System.out.println("Cannot get all sessionFilm objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sessionFilms;
    }

    @Override
    public SessionFilm findByID(int id) {
        SessionFilm sessionFilm = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            sessionFilm = session.get(SessionFilm.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get sessionFilm object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sessionFilm;
    }
}
