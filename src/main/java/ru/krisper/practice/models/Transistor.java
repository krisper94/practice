package ru.krisper.practice.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "transistor")
public class Transistor implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="type_id", nullable = false)
    private Type type;

    @NotNull
    @Column(name = "specs_link")
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
