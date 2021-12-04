package pl.sda.springproject2.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject2.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PersonServiceMemory implements PersonService {
    private Map<String,Person> personMap = new HashMap<>();
    private long currentId = 1;

    public PersonServiceMemory(){
        Person person = Person.builder()
                .firstName("Marian")
                .lastName("Banaś")
                .salary(15100)
                .pesel("12345678912")
                .build();
        add(person);

         person = Person.builder()
                .firstName("Janusz")
                .lastName("Korwin Mikke")
                .salary(11000)
                .pesel("12312312312")
                .build();
        add(person);

        person= Person.builder()
                .firstName("Daniel")
                .lastName("Obajtek")
                .salary(120000)
                .pesel("14725836933")
                .build();
        add(person);

        person = Person.builder()
                .firstName("Kuba")
                .lastName("Wojewodzki")
                .salary(34000)
                .pesel("19734682456")
                .build();
        add(person);

    }

    @Override
    public Person add(Person person) {
        person.setId(currentId++);
        person.setPesel(person.getPesel());
        personMap.put(person.getPesel(),person);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(personMap.values());
    }

    @Override
    public void setifAvailable(String pesel) {
        personMap.get(pesel).setAvailable(true);

    }
}
