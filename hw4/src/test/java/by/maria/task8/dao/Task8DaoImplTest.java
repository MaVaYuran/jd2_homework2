package by.maria.task8.dao;

import by.maria.HWSessionFactory;
import by.maria.HWTestSessionFactory;
import by.maria.task8.joined.entity.Employee1;
import by.maria.task8.joined.entity.Student1;
import by.maria.task8.mapped.entity.InheritClass;
import by.maria.task8.single_table.entity.Employee;
import by.maria.task8.single_table.entity.Student;
import by.maria.task8.table_per_class.entity.Programer;
import by.maria.task8.table_per_class.entity.Role;
import by.maria.task8.table_per_class.entity.Tester;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task8DaoImplTest {
    Task8Dao task8Dao;

    @Before
    public void setUp() throws Exception {
        task8Dao = new Task8DaoImpl(HWTestSessionFactory.getSessionFactory());
    }

    @After
    public void tearDown() throws Exception {
        task8Dao = null;
    }

    @Test
    public void saveSingleTableMethod() {

        Employee employee = new Employee();

        employee.setName("Vasya");
        employee.setSurname("Ivanov");
        employee.setCompany("IBM group");
        employee.setSalary(900.00);

        Student student = new Student();

        student.setName("Emilien");
        student.setSurname("Jacquelin");
        student.setFaculty("Culturology");
        student.setMark(9.5);
        try (Session session = HWSessionFactory.getSessionFactory().openSession()) {

            Integer savedIdE = (Integer) session.save(employee);
            Integer savedIdS = (Integer) session.save(student);


            Employee savedEmpl = session.get(Employee.class, savedIdE);
            Student savedStud = session.get(Student.class, savedIdS);

            System.out.println(savedEmpl);
            System.out.println(savedStud);
        }
    }

    @Test
    public void mappedSuperClass() {


        InheritClass inherit = new InheritClass("Class x");
        try (Session session = HWTestSessionFactory.getSessionFactory().openSession()) {
            Integer savedId = (Integer) session.save(inherit);
            InheritClass saved = session.get(InheritClass.class, savedId);
            System.out.println(saved);
        }
    }

    @Test
    public void saveJoinedMethod() {
        Employee1 employee = new Employee1("Yandex", 1000.0);
        Student1 student = new Student1("Management", 7.85);
        try (Session session = HWTestSessionFactory.getSessionFactory().openSession()) {

            Integer savedID1 = (Integer) session.save(employee);
            Integer savedID2 = (Integer) session.save(student);

            Employee1 savedEmp = session.get(Employee1.class, savedID1);
            Student1 savedSt = session.get(Student1.class, savedID2);
            System.out.println(savedID1 + " " + savedEmp);
            System.out.println(savedID2 + " " + savedSt);
        }
    }


    @Test
    public void saveTablePerClassMethod() {
        Programer programer = new Programer(null, "Programer", Role.ADMIN, "Java");
        Tester tester = new Tester(null, "Tester", Role.USER, "Test-case");

        try (Session session = HWTestSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long savedIdP = (Long) session.save(programer);
            Long savedIdT = (Long) session.save(tester);
            session.flush();
            session.clear();

            Programer savedProgramer = session.get(Programer.class, savedIdP);
            Tester savedTester = session.get(Tester.class, savedIdT);

            System.out.println(savedProgramer);
            System.out.println(savedTester);

            session.getTransaction().commit();
        }

    }

}