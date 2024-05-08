package com.msbkn.core.service;

import com.msbkn.core.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private String path = "personData.txt";


    public PersonService() {
        createdFile();



    }

    private void createdTest() {
        Person person = new Person(2, "test", null);
        createDataPerson(person);
    }

    private void createdFile() {
        File file = new File(path);
        try {

            boolean result = file.createNewFile();
            if (result) {
                System.out.println("Dosya oluşturuldu..");
            } else {
                System.out.println("Dosya zaten mevcut..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createDataPerson(Person person) {
        try {
            List<Person> personList = fillPersonList();
            personList.add(person);
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(personList);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Person> fillPersonList() {
        try {
            List<Person> personList = new ArrayList<Person>();

            FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object object = objectInputStream.readObject();

            if (object instanceof Person) {
                Person person = (Person) object;
                personList.add(person);

            } else {
                personList = (List<Person>) object;
            }
            return personList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
