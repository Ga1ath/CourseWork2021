package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Customer;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDAOimplementation implements CustomerDAO {
    private Session session = null;

    @Override
    public void add(Customer customer) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot add customer object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot update customer object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Customer customer) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Cannot delete customer object: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            customers = (List<Customer>)session.createQuery("From Customer").list();
        } catch (Exception e) {
            System.out.println("Cannot get all customer objects: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customers;
    }

    @Override
    public Customer findByID(int id) {
        Customer customer = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            customer = session.get(Customer.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get customer object by id: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }
}
