package com.msbkn.core.model;

import com.vaadin.ui.Image;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private long id;
    private String name;
    private String imagePath;



    public Person(long id, String name, String imagePath) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
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


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(imagePath, person.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imagePath);
    }

}
