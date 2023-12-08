package by.maria.task910;

import by.maria.HWTestSessionFactory;
import by.maria.task910.entity.Book;
import by.maria.task910.entity.Rector;
import by.maria.task910.entity.University;
import by.maria.task910.entity.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.OneToOne;

public class MainTest {
//
//    @Test
//    public void checkOneToOne() {
//        try (SessionFactory factory = HWTestSessionFactory.getSessionFactory();
//             Session session = factory.openSession()) {
//            session.beginTransaction();
//            Rector rector = new Rector("Pavel Ivanovich", 38);
//            University university = new University("BGU", 25);
//
//            session.save(university);
//            rector.setUniversity(university);
//            session.save(rector);
//
//            System.out.println("rector: " + rector);
//
//            session.getTransaction().commit();
//        }
//    }
//
//    @Test
//    public void checkOneToMany() {
//        try (SessionFactory factory = HWTestSessionFactory.getSessionFactory()) {
//            try (Session session = factory.openSession()) {
//                session.beginTransaction();
//                Writer writer = new Writer("Paulo Koelho");
//                Book book1 = new Book("O Alquimista", 1988, writer);
//                Book book2 = new Book("O Monte Cinco", 1996, writer);
//
//                session.save(writer);
//                session.save(book1);
//                session.save(book2);
//                session.getTransaction().commit();
//            }
//            try (Session session1 = factory.openSession()) {
//                session1.beginTransaction();
//                Writer writer1 = session1.get(Writer.class, 1);
//
//                System.out.println(writer1.getBooks());
//                session1.getTransaction().commit();
//            }
//        }
//    }
}