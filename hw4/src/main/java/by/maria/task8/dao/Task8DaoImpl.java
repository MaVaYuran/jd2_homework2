package by.maria.task8.dao;

import by.maria.task8.joined.entity.Person1;
import by.maria.task8.single_table.entity.Person;
import by.maria.task8.table_per_class.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;

public class Task8DaoImpl implements Task8Dao{
    private final SessionFactory sessionFactory;

    public Task8DaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer saveSingleTableMethod(Person1 person1) {
        Session session = null;
        Transaction transaction = null;
        Integer savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(person1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null)
                session.close();
        }
        return savedId;


    }

    @Override
    public Person1 getPerson1(int id) {
        Session session = null;
        Transaction transaction = null;
        Person1 person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.get(Person1.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return person;
    }

    @Override
    public Integer saveJoinedMethod(Person person) {
        Session session = null;
        Transaction transaction = null;
        Integer savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null)
                session.close();
        }
        return savedId;

    }

    @Override
    public Person getPerson(int id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.get(Person.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return person;
    }

    @Override
    public Integer saveTablePerClassMethod(User user) {
        Session session = null;
        Transaction transaction = null;
        Integer savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null)
                session.close();
        }
        return savedId;

    }

    @Override
    public User getUser(int id) {
        Session session = null;
        Transaction transaction = null;
        User user;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return user;
    }
}
