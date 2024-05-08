package com.msbkn.core.service;
import com.msbkn.core.model.Person;
import java.util.List;

public interface PersonService {

     boolean savePerson(Person person);
    List<Person> fillPersons();
}
