package by.maria.task8.joined.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "STUDENT1")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Student1 extends Person1 {
    private static final long serialVersionUID = 3L;
    private String faculty;
    private Double mark;

    public Student1() {
    }

    public Student1(String faculty, Double mark) {
        this.faculty = faculty;
        this.mark = mark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student1 student1 = (Student1) o;

        if (!Objects.equals(faculty, student1.faculty)) return false;
        return Objects.equals(mark, student1.mark);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }
}
