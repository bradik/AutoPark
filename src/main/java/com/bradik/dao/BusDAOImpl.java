package com.bradik.dao;

import com.bradik.logic.*;
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
public class BusDAOImpl implements BusDAO {

    public void addBus(Bus bus) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(bus);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке:");
            System.err.println(e.getCause().toString());
        }
    }

    public void updateBus(Long bus_id, Bus bus) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.update(bus);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке:");
            System.err.println(e.getCause().toString());
        }
    }

    public Bus getBusById(Long bus_id) throws SQLException {
        Bus bus = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            bus = (Bus) session.load(Bus.class, bus_id);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById':");
            System.err.println(e.getCause().toString());
        }
        return bus;
    }

    @Override
    public Bus getBusByNymber(String number) throws SQLException {
        Bus bus = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {

            Query query = session.createQuery("from Bus where number = :number").setString("number", number);
            List<Bus> list = query.list();
            if (list.size()>0)
                bus = (Bus) list.get(0);
        } catch (Exception e) {
            System.err.println("Ошибка 'findByNumber':");
            System.err.println(e.getCause().toString());
        }
        return bus;
    }

    public Collection getAllBusses() throws SQLException {
        List busses = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            busses = session.createCriteria(Bus.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'");
            System.err.println(e.getCause().toString());
        }
        return busses;
    }

    public void deleteBus(Bus bus) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.delete(bus);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении");
            System.err.println(e.getCause().toString());
        }
    }

    public Collection getBussesByDriver(Driver driver) throws SQLException {
        List busses = new ArrayList<Bus>();
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            Long driver_id = driver.getId();
            Query query = session.createQuery(
                    " select b "
                            + " from Bus b INNER JOIN b.drivers driver"
                            + " where driver.id = :driverId "
            )
                    .setLong("driverId", driver_id);
            busses = (List<Bus>) query.list();
            session.getTransaction().commit();

        }
        return busses;
    }

    public Collection getBussesByRoute(Route route) {
        List busses = new ArrayList<Bus>();
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            Long route_id = route.getId();
            Query query = session.createQuery("from Bus where route_id = :routeId ").setLong("routeId", route_id);
            busses = (List<Bus>) query.list();
            session.getTransaction().commit();

        }
        return busses;
    }
}
