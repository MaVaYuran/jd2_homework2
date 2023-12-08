package by.maria.task8.single_table.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person {
    private static final Long serialVersionUID = 3l;
    private String faculty;
    private Double mark;

    public Student() {
    }

    public Student(String faculty, Double mark) {
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

        Student student = (Student) o;

        if (!Objects.equals(faculty, student.faculty)) return false;
        return Objects.equals(mark, student.mark);
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark +
                "} " + super.toString();
    }
}
