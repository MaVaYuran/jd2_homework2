package by.maria.task8.joined.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="EMPLOYEE1")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class Employee1 extends Person1 {
    private static final long serialVersionUID = 2L;
    private String company;
    private Double salary;

    public Employee1() {
    }

    public Employee1(String company, Double salary) {
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee1 employee1 = (Employee1) o;

        if (!Objects.equals(company, employee1.company)) return false;
        return Objects.equals(salary, employee1.salary);
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }
}
