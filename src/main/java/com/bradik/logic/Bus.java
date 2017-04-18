package com.bradik.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brad on 15.04.2017.
 */
public class Bus {
    private Long id;
    private String number;
    private Long route_id;
    private Set drivers = new HashSet();

    public Bus() {
    }

    public Bus(String number) {
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDrivers(Set drivers) {
        this.drivers = drivers;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Set getDrivers() {
        return drivers;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Bus obj2 = (Bus) obj;
        if ((this.id == obj2.getId()) && (this.number.equals(obj2.getNumber()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (id + number).hashCode();
        return tmp;
    }

}
