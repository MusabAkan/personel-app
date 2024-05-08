package com.msbkn.core.model;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private long id;

    private String name;

    private File image;

    public Person(long id, String name, File image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(image, person.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image);
    }
}
