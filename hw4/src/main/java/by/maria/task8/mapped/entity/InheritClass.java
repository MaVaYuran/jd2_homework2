package by.maria.task8.mapped.entity;


import javax.persistence.Entity;
import java.util.Objects;

@Entity

public class InheritClass extends BaseClass<Integer>{
    private String name;

    public InheritClass() {
    }

    public InheritClass(String name) {
        this.name = name;
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

        InheritClass that = (InheritClass) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "InheritClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
