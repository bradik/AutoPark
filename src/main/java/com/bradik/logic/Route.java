package com.bradik.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brad on 15.04.2017.
 */
public class Route {
    private Long id;
    private String name;
    private int number;
    private Set busses = new HashSet();

    public Route() {
    }

    public Route(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set getBusses() {
        return busses;
    }

    public void setBusses(Set busses) {
        this.busses = busses;
    }

    public void addBus(Bus bus) {
        busses.add(bus);
    }

    public void removeBus(Bus bus) {
        busses.remove(bus);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Route obj2 = (Route) obj;
        if ((this.id == obj2.getId()) && (this.number == obj2.getNumber()) && (this.name.equals(obj2.getName()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (id + number + name).hashCode();
        return tmp;
    }
}
