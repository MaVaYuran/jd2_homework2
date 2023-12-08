package by.maria.task8.table_per_class.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="TESTER")
public class Tester extends User{
    private static final long serialVersionUID =3L;
    private String testCase;

    public Tester() {
    }

    public Tester(Long id, String username, Role role, String testCase) {
        super(id, username, role);
        this.testCase = testCase;
    }

    public String getTestCase() {
        return testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tester tester = (Tester) o;

        return Objects.equals(testCase, tester.testCase);
    }

    @Override
    public String toString() {
        return "Tester{" +
                "testCase='" + testCase + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (testCase != null ? testCase.hashCode() : 0);
        return result;
    }
}
