package ru.krisper.practice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Transistor {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @ManyToOne
    private Type type;

    @NotNull
    private String specs_link;

    public Transistor() {
    }

    public Transistor(String name, String specs_link) {
        this.name = name;
        this.specs_link = specs_link;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecs_link() {
        return specs_link;
    }

    public void setSpecs_link(String specs_link) {
        this.specs_link = specs_link;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
