package fr.normand.demoSpring.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;


public class Fruit {

    private long id;

    private String name;

    public Fruit(String name) {
        this.id = id;
        this.name = name;
    }


    public Fruit(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
