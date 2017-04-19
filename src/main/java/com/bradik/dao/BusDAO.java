package com.bradik.dao;

import com.bradik.logic.*;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Brad on 15.04.2017.
 */
public interface BusDAO {

    public void addBus(Bus bus) throws SQLException;

    public void updateBus(Long bus_id, Bus bus) throws SQLException;

    public Bus getBusById(Long bus_id) throws SQLException;

    public Bus getBusByNymber(String number) throws SQLException;

    public void deleteBus(Bus bus) throws SQLException;

    public Collection getAllBusses() throws SQLException;

    public Collection getBussesByDriver(Driver driver) throws SQLException;

    public Collection getBussesByRoute(Route route) throws SQLException;

}
