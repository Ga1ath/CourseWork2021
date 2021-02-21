package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Film;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilmDAOimplementation implements FilmDAO {
    private Session session = null;

    @Override
    public void add(Film film) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add film object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Film film) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(film);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update film object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Film film) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(film);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete film object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Film> getAll() {
        List<Film> films = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            films = (List<Film>)session.createQuery("From Film").list();
        } catch (Exception e) {
            System.out.println("Cannot get all film objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return films;
    }

    @Override
    public Film findByID(int id) {
        Film film = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            film = session.get(Film.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get film object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return film;
    }
}
