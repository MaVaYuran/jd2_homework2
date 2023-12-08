package by.maria.task8.single_table.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person {
    private static final long serialVersionUID = 4L;
    private String company;
    private Double salary;

    public Employee() {
    }

    public Employee(String company, Double salary) {
        super();
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

        Employee employee = (Employee) o;

        if (!Objects.equals(company, employee.company)) return false;
        return Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
