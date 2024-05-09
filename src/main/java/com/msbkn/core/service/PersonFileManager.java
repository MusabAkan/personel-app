package com.msbkn.core.service;

import com.msbkn.core.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileManager implements PersonService {

    private String pathUrl = "c:/uploads/personData.txt";

    public PersonFileManager() {
        createFileIfNotExists();
    }

    private void createFileIfNotExists() {
        File file = new File(pathUrl);
        try {
            boolean exists = file.exists();
            if (exists)     System.out.println("Dosya zaten mevcut..");
            else            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean savePerson(Person person) {
        try {

            List<Person> personList = readAllPersonFromFile();
            personList.add(person);

            writeToFile(personList);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void writeToFile(List<Person> personList) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(pathUrl);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(personList);
        objectOutputStream.close();
    }

    @Override
    public List<Person> readAllPersonFromFile() {
        try {
            FileInputStream inputStream = new FileInputStream(pathUrl);
            if (inputStream.available() == 0) return new ArrayList<>();

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object object = objectInputStream.readObject();
            return  (List<Person>) object;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Person findPersonById(long id) {
        List<Person> personList = readAllPersonFromFile();
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}