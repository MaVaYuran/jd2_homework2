package by.maria.task7.dao;

import by.maria.task7.dao.Dao;
import by.maria.task7.entity.Car;
import by.maria.task7.entity.Cat;
import by.maria.task7.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Id;

public class DaoImpl implements Dao {
    private final SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer saveEmbadded(Car car) {
        Session session = null;
        Transaction transaction = null;
        Integer savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(car);
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
    public Long saveOwner(Owner owner) {
        Session session = null;
        Transaction transaction = null;
        Long savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Long) session.save(owner);
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
    public String saveCat(Cat cat) {
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(cat);
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

}
