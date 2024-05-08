package com.msbkn.core.service;

import com.msbkn.core.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileManager implements PersonService {


    private String pathUrl = "c:/uploads/personData.txt";

    public PersonFileManager() {
        createdFile();
    }

    private void createdFile() {
        File file = new File(pathUrl);
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

    @Override
    public boolean savePerson(Person person) {
        try {

            List<Person> personList = new ArrayList<>();

            personList = fillPersons();
            personList.add(person);

            FileOutputStream outputStream = new FileOutputStream(pathUrl);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(personList);
            objectOutputStream.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Person> fillPersons() {
        try {
            List<Person> personList = new ArrayList<Person>();

            FileInputStream inputStream = new FileInputStream(pathUrl);

            if (inputStream.available() == 0)
                return new ArrayList<>();

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
            return new ArrayList<>();
        }
    }

    @Override
    public Person findPersonById(long id) {
        List<Person> personList = fillPersons();
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}
