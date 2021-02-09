package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Row;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RowDAOimplementation implements RowDAO {
    private Session session = null;

    @Override
    public void add(Row row) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(row);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add row object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Row row) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(row);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update row object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Row row) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(row);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete row object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Row> getAll() {
        List<Row> rows = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            rows = (List<Row>)session.createQuery("From Row").list();
        } catch (Exception e) {
            System.out.println("Cannot get all row objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return rows;
    }

    @Override
    public Row findByID(int id) {
        Row row = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            row = session.get(Row.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get row object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return row;
    }
}
