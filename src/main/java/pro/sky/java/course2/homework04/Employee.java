package pro.sky.java.course2.homework04;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Integer depNumber;
    private Double salary;

    public Employee(String firstName, String lastName, Integer depNumber, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.depNumber = depNumber;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepNumber() {
        return depNumber;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(depNumber, employee.depNumber) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, depNumber, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", depNumber=" + depNumber +
                ", salary=" + salary +
                '}';
    }
}
