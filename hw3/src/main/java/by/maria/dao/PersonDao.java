package by.maria.dao;

import by.maria.entity.Person;

import java.util.List;

public interface PersonDao {
    Integer savePerson(Person person);
    Person readPersonById(int id);
    boolean deletePersonById(int id);
    List<Person> readAll();
    Person loadPerson(int id);
    void flushSessionMethod();
    void clearSessionMethod();
}
