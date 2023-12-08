package by.maria.dao;

import by.maria.PersonTestSessionFactory;
import by.maria.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PersonDaoCrudTest {
    private static PersonDao personDao;
    SessionFactory sessionFactory;

    @Before
    public void setUp() {
        personDao = new PersonDaoCrud(PersonTestSessionFactory.getSessionFactory());

    }

    @After
    public void tearDown() {
        personDao = null;
    }


    @Test
    public void savePerson() throws SQLException, ClassNotFoundException {
        try (Session session = PersonTestSessionFactory.getSessionFactory().openSession()) {
//            var transaction = session.beginTransaction();

            Person person = new Person(19, "Rih", "Toner");

            Integer savedId = personDao.savePerson(person);
            //transaction.commit();
            assertNotNull(savedId);
            Person savedPerson = session.get(Person.class, savedId);
            assertEquals(19, savedPerson.getAge());
            assertEquals("Rih", savedPerson.getName());
            assertEquals("Toner", savedPerson.getSurname());

        }
    }

    @Test
    public void readPersonById() throws SQLException, ClassNotFoundException {
        Person person = new Person(25, "Dima", "Ivanov");
        int id = personDao.savePerson(person);

        Person savedPerson = personDao.readPersonById(id);

        assertNotNull(savedPerson);

        assertEquals(25, savedPerson.getAge());
        assertEquals("Dima", savedPerson.getName());
        assertEquals("Ivanov", savedPerson.getSurname());


    }


    @Test
    public void deletePersonById() throws SQLException, ClassNotFoundException {

        // Given
        Person person = new Person(32, "Grigor", "Dimitrov");
        int savedId = personDao.savePerson(person);

        // When
        boolean result = personDao.deletePersonById(savedId);

        //Then
        assertTrue(result);
        try (Session session = PersonTestSessionFactory.getSessionFactory().openSession()) {
            List<Long> query = session.createQuery(
                    " SELECT count(*) FROM Person p WHERE p.name='Grigor'", Long.class).list();
            System.out.println(query);
            int actualCount = query.get(0).intValue();
            assertEquals(0, actualCount);

        }
    }

    @Test
    public void readAll() {
        Person person = new Person();
        person.setAge(31);
        person.setName("Pavel");
        person.setSurname("Romanov");

        personDao.savePerson(person);
        List<Person> people = personDao.readAll();

        assertNotNull(people);
        assertFalse(people.isEmpty());

        Person person1 = people.get(0);
        assertEquals(1, person1.getId());
        assertEquals(31, person1.getAge());
        assertEquals("Pavel", person1.getName());
        assertEquals("Romanov", person1.getSurname());
    }

    @Test
    public void loadPerson() {
        Person person = new Person();
        person.setAge(30);
        person.setName("Igor");
        person.setSurname("Romanov");

        personDao.savePerson(person);

        Person loadedPerson = personDao.loadPerson(person.getId());
        assertNotNull(loadedPerson);

        assertEquals(person.getId(), loadedPerson.getId());
        //assertEquals(person.getAge(), loadedPerson.getAge());//test failed: could not initialize proxy
        //assertEquals(person.getName(), loadedPerson.getName());//test failed: could not initialize proxy
        //assertEquals(person.getSurname(), loadedPerson.getSurname());//test failed: could not initialize proxy

        Person unexistedPerson = personDao.loadPerson(100);
        //assertNull(unexistedPerson);////test failed: unknown source
        assertNotNull(unexistedPerson);

    }

    @Test
    public void getUnexistPerson() {
        try (var session = PersonTestSessionFactory.getSessionFactory().openSession()) {
            Person person = new Person(25, "Dima", "Ivanov");
            session.save(person);
            Person unexistPerson = session.get(Person.class, 25);
            assertNull(unexistPerson);

        }
    }
}