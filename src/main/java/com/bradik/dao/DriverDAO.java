package com.bradik.dao;

import com.bradik.logic.Driver;

import java.sql.SQLException;

/**
 * Created by Brad on 15.04.2017.
 */
public interface DriverDAO {

    public void addDriver(Driver driver) throws SQLException;

    public void updateDriver(Long id, Driver driver) throws SQLException;

    public Driver getDriverById(Long id) throws SQLException;

    public void deleteDriver(Driver driver) throws SQLException;
}
