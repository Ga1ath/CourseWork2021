package com.example.cinema_booking.dao;

import com.example.cinema_booking.models.Customer;
import com.example.cinema_booking.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDAOimplementation implements CustomerDAO {
    private Session session = null;
    private Customer customer = null;

    @Override
    public Exception add(Customer customer) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            return null;
        } catch (Exception e) {
            System.out.println("Cannot add customer object: " + e.getMessage());
            return e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Exception update(Customer customer) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
            return null;
        } catch (Exception e) {
            System.out.println("Cannot update customer object: " + e.getMessage());
            return e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Exception delete(Customer customer) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
            return null;
        } catch (Exception e) {
            System.out.println("Cannot delete customer object: " + e.getMessage());
            return e;
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
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            customer = session.get(Customer.class, id);
        } catch (Exception e) {
            System.out.println("Cannot get customer object by ID: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }

    @Override
    public Customer findByLoginName(String loginName) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            Query query = session.createQuery(
                    "select c from Customer c where c.LoginName=:loginName", Customer.class);
            query.setParameter("loginName", loginName);
            customer = (Customer) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Cannot get customer object by LoginName: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }
}
