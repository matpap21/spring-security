package pl.sda.springproject2.service;

import pl.sda.springproject2.model.Person;

import java.util.List;

public interface PersonService {
    Person add(Person person);
    List<Person> findAll();
    void setifAvailable(String pesel);
}
