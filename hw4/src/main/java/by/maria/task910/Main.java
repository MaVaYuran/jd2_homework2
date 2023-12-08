package by.maria.task910;

import by.maria.HWSessionFactory;
import by.maria.task910.entity.Book;
import by.maria.task910.entity.Rector;
import by.maria.task910.entity.University;
import by.maria.task910.entity.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
//        try (SessionFactory sessionFactory = HWSessionFactory.getSessionFactory()) {
//            try (var session = sessionFactory.openSession()) {
//                session.beginTransaction();
//
//                Rector rector = new Rector("Pavel Ivanovich", 38);
//                University university = new University("BGU", 25);
//
//                session.save(university);
//                rector.setUniversity(university);
//                session.save(rector);
//
//                System.out.println("rector: " + rector);
//
//                session.getTransaction().commit();
//            }
//            try (Session session1 = sessionFactory.openSession()) {
//                session1.beginTransaction();
//
//                Writer writer = new Writer("Paolo Koelyo");
//                Book book1 = new Book("O Alquimista", 1988, writer);
//                Book book2 = new Book("O Monte Cinco", 1996, writer);
//
//                session1.save(writer);
//                session1.save(book1);
//                session1.save(book2);
//
//
//                session1.getTransaction().commit();
//            }
//            try (Session session2 = sessionFactory.openSession()) {
//                session2.beginTransaction();
//
//                Writer writer1 = session2.get(Writer.class, 1);
//                System.out.println(writer1.getBooks());
//
//                session2.getTransaction().commit();
//            }
//        }
   }
}