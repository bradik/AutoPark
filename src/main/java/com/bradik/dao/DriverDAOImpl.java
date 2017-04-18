package com.bradik.dao;

import com.bradik.logic.Bus;
import com.bradik.logic.Driver;
import com.bradik.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Brad on 15.04.2017.
 */
public class DriverDAOImpl implements DriverDAO {
    public void addDriver(Driver driver) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке:");
            System.err.println(e.getCause().toString());
        }
    }

    public void updateDriver(Long id, Driver driver) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(driver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке:");
            System.err.println(e.getCause().toString());
        }

    }

    public Driver getDriverById(Long id) throws SQLException {
        Driver driver = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            driver = session.load(Driver.class,id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка 'findById':");
            System.err.println(e.getCause().toString());
        }

        return driver;
    }

    public void deleteDriver(Driver driver) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(driver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении:");
            System.err.println(e.getCause().toString());
        }
    }

    @Override
    public Collection getAllDrivers() throws SQLException {
        List<Driver> list = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            list = session.createCriteria(Driver.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'");
            System.err.println(e.getCause().toString());
        }
        return list;
    }

    @Override
    public Collection getDriversByBus(Bus bus) throws SQLException {

        List<Driver> list = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Long bus_id = bus.getId();
            Query query = session.createQuery(
                    " select d "
                            + " from Driver d INNER JOIN d.busses busses"
                            + " where busses.id = :busId "
            )
                    .setLong("busId", bus_id);
            list = query.list();
        }
        return list;
    }
}

