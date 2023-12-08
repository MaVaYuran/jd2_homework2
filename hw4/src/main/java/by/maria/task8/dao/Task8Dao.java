package by.maria.task8.dao;

import by.maria.task8.joined.entity.Person1;
import by.maria.task8.single_table.entity.Person;
import by.maria.task8.table_per_class.entity.User;

public interface Task8Dao {
    Integer saveSingleTableMethod(Person1 person);
    Person1 getPerson1(int id);

    Integer saveJoinedMethod(Person person);
    Person getPerson(int id);

    Integer saveTablePerClassMethod(User user);
    User getUser(int id);
}
