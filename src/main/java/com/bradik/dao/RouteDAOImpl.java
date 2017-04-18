package com.bradik.dao;

import com.bradik.logic.Bus;
import com.bradik.logic.Route;
import com.bradik.utils.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Brad on 15.04.2017.
 */
public class RouteDAOImpl implements RouteDAO {

    @Override
    public void addRoute(Route route) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке:");
            System.err.println(e.getCause().toString());
        }
    }

    @Override
    public void updateRoute(Long id, Route route) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке:");
            System.err.println(e.getCause().toString());
        }
    }

    @Override
    public Route getRouteById(Long id) throws SQLException {

        Route route = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            route = session.load(Route.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка 'findById':");
            System.err.println(e.getCause().toString());
        }

        return route;
    }

    @Override
    public void deleteRoute(Route route) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        }

    }

    @Override
    public Collection getAllRoutes() throws SQLException {
        List routes = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            routes.addAll(session.createCriteria(Route.class).list());
        } catch (Exception e) {
            System.err.println("Ошибка при удалении:");
            System.err.println(e.getCause().toString());
        }
        return routes;
    }
}
