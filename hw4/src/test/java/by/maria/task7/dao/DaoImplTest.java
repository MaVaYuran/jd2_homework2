package by.maria.task7.dao;

import by.maria.HWTestSessionFactory;
import by.maria.task7.dao.Dao;
import by.maria.task7.dao.DaoImpl;
import by.maria.task7.entity.*;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DaoImplTest {
    private static Dao dao;

    @Before
    public void setUp() {
        dao = new DaoImpl(HWTestSessionFactory.getSessionFactory());
    }

    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void saveEmbadded() {
        try (Session session = HWTestSessionFactory.getSessionFactory().openSession()) {
            Car car = new Car(
                    "Audi A4", 2007, Color.BLACK, new MotorInfo(
                    "Audi", MotorType.PETROL, 2.0, 200));
            Integer savedId = dao.saveEmbadded(car);
            assertNotNull(car);
            Car savedCar = session.get(Car.class, savedId);
            assertEquals("Audi A4", savedCar.getModel());
            assertEquals(2007, savedCar.getManufacturedYear());
            assertEquals(Color.BLACK, savedCar.getColor());
            assertEquals(car.getMotorInfo().getProducer(),
                    savedCar.getMotorInfo().getProducer());
            assertEquals(car.getMotorInfo().getType(),
                    savedCar.getMotorInfo().getType());
            assertEquals(car.getMotorInfo().getVolume(),
                    savedCar.getMotorInfo().getVolume());
            assertEquals(car.getMotorInfo().getHorsePower(),
                    savedCar.getMotorInfo().getHorsePower());
        }
    }

    @Test
    public void saveOwner() {
        try (Session session = HWTestSessionFactory.getSessionFactory().openSession()) {
            Owner owner = new Owner(2);
            Owner owner1 = new Owner(3);
            Long savedId = dao.saveOwner(owner);
            Long savedId1 = dao.saveOwner(owner1);
            assertNotNull(owner);
            assertNotNull(owner1);

            Owner loadedOwner = session.get(Owner.class, savedId);
            Owner loadedOwner1 = session.get(Owner.class, savedId1);

            assertEquals(owner.getNumberOfCat(), loadedOwner.getNumberOfCat());
            assertEquals(owner1.getNumberOfCat(), loadedOwner1.getNumberOfCat());

        }
    }

    @Test

    public void saveCat() {
        Cat cat = new Cat(null, "Boy");
        try (Session session = HWTestSessionFactory.getSessionFactory().openSession()) {
            String savedId = (String) session.save(cat);

            System.out.println(savedId);
        }
    }
}