package by.maria.task7.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PETS")
    private int numberOfCat;



    public Owner() {
    }

    public Owner(int numberOfCat) {
        this.numberOfCat = numberOfCat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfCat() {
        return numberOfCat;
    }

    public void setNumberOfCat(int numberOfCat) {
        this.numberOfCat = numberOfCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (numberOfCat != owner.numberOfCat) return false;
        return Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + numberOfCat;
        return result;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", numberOfCat=" + numberOfCat +
                '}';
    }
}


