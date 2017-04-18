package com.bradik.dao;

import com.bradik.logic.Bus;
import com.bradik.logic.Driver;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Brad on 15.04.2017.
 */
public interface DriverDAO {

    public void addDriver(Driver driver) throws SQLException;

    public void updateDriver(Long id, Driver driver) throws SQLException;

    public Driver getDriverById(Long id) throws SQLException;

    public void deleteDriver(Driver driver) throws SQLException;

    public Collection getAllDrivers() throws SQLException;

    public Collection getDriversByBus(Bus bus) throws SQLException;



}
