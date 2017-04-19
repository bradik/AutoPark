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
@Table(name = "routes")
public class Route extends ManagedEntity {

    @NotNull
    @Length(max = 30)
    private String name;

    @NotNull
    private int number;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    private Set<Bus> busses = new HashSet<>();

    public Route() {}

    public Route(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void addBus(Bus bus) { busses.add(bus); }

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

    public Set<Bus> getBusses() {
        return busses;
    }

    public void setBusses(Set<Bus> busses) {
        this.busses = busses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Route obj2 = (Route) obj;
        if ((this.getId() == obj2.getId()) && (this.number == obj2.getNumber()) && (this.name.equals(obj2.getName()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (getId() + number + name).hashCode();
        return tmp;
    }
}
