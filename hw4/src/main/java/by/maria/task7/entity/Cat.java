package by.maria.task7.entity;

import by.maria.task7.entity.Owner;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity

public class Cat {
    @Id
    @GenericGenerator(strategy = "uuid", name = "cat_uuid")
    @GeneratedValue(generator = "cat_uuid")
    @Column(name = "id")
    private String id;
    private String name;


    public Cat() {
    }

    public Cat(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", name='" + name +
                '}';
    }
}
