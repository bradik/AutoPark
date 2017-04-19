package com.bradik.logic;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brad on 15.04.2017.
 */
@Entity
@Table(name = "busses" , indexes = {@Index(columnList = "number", name = "number_hidx")})
public class Bus extends ManagedEntity {

    @NotNull
    @Length(max = 6)
    private String number;

    @ManyToOne
    @JoinColumn(name = "route_id", insertable=false, updatable=false)
    private Route route;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "driver_bus",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private Set<Driver> drivers = new HashSet<>();

    public Bus() {}

    public Bus(String number) {
        this.number = number;
    }

    public void addDriver(Driver driver) { drivers.add(driver); }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Bus obj2 = (Bus) obj;
        if ((this.getId() == obj2.getId()) && (this.number.equals(obj2.getNumber()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (getId() + number).hashCode();
        return tmp;
    }
}
