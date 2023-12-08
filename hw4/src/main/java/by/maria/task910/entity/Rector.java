package by.maria.task910.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne()
    @JoinColumn(name = "university_id")
    private University university;
    private String name;
    private int experience;

    public void setUniversity(University university){
        this.university = university;
        university.setRector(this);
    }

    public Rector() {
    }


    public Rector( String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

//    public void setUniversity(University university) {
//        this.university = university;
//    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rector rector = (Rector) o;

        if (experience != rector.experience) return false;
        if (!Objects.equals(id, rector.id)) return false;
        if (!Objects.equals(university, rector.university)) return false;
        return Objects.equals(name, rector.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + experience;
        return result;
    }

    @Override
    public String toString() {
        return "Rector{" +
                "id=" + id +
                ", university=" + university +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
