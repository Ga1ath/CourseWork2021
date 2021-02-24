package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Ticket;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TicketDAOimplementation implements TicketDAO {
    private Session session = null;

    @Override
    public void add(Ticket ticket) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add ticket object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Ticket ticket) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update ticket object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete ticket object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Ticket> getAll() {
        List<Ticket> tickets = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            tickets = (List<Ticket>)session.createQuery("From Ticket").list();
        } catch (Exception e) {
            System.out.println("Cannot get all ticket objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tickets;
    }

    @Override
    public Ticket findByID(int id) {
        Ticket ticket = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            ticket = session.get(Ticket.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get ticket object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ticket;
    }
}
