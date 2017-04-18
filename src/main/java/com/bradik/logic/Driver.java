package com.bradik.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brad on 15.04.2017.
 */
public class Driver {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private Set busses = new HashSet();

    public Driver() {
    }

    public Driver(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public Set getBusses() {
        return busses;
    }

    public void setBusses(Set busses) {
        this.busses = busses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Driver obj2 = (Driver) obj;
        if ((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (id + name).hashCode();
        return tmp;
    }
}
