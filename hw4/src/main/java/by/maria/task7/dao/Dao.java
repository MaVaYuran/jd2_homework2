package by.maria.task7.dao;

import by.maria.task7.entity.Car;
import by.maria.task7.entity.Cat;
import by.maria.task7.entity.Owner;

public interface Dao {
    Integer saveEmbadded(Car car);

    Long saveOwner(Owner owner);

    String saveCat(Cat cat);
}
