package com.bradik.dao;

import com.bradik.logic.Route;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Brad on 15.04.2017.
 */
public interface RouteDAO {

    public void addRoute(Route route) throws SQLException;

    public void updateRoute(Long id, Route route) throws SQLException;

    public Route getRouteById(Long id) throws SQLException;

    public void deleteRoute(Route route) throws SQLException;

    public Collection getAllRoutes() throws SQLException;


}
