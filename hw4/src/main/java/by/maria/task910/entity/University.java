package by.maria.task910.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "university", cascade = CascadeType.ALL)
    private Rector rector;
    private String name;
    private int facultyNumber;

    public University() {
    }

    public University(String name, int facultyNumber) {

        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rector getRector() {
        return rector;
    }

    public void setRector(Rector rector) {
        this.rector = rector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        if (facultyNumber != that.facultyNumber) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(rector, that.rector)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + facultyNumber;
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facultyNumber=" + facultyNumber +
                '}';
    }
}
