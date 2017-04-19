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
@Table(name = "drivers")
public class Driver extends ManagedEntity {
    @NotNull
    @Length(max = 20)
    private String name;

    @NotNull
    @Length(max = 20)
    private String surname;

    private int age;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "driver_bus",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private Set<Bus> busses = new HashSet<>();

    public Driver() {
    }

    public Driver(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void addBus(Bus bus) {
        busses.add(bus);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

        Driver obj2 = (Driver) obj;
        if ((this.getId() == obj2.getId()) && (this.name.equals(obj2.getName()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (getId() + name).hashCode();
        return tmp;
    }
}
