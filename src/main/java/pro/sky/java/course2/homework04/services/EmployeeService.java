package pro.sky.java.course2.homework04.services;

import pro.sky.java.course2.homework04.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName, Integer depNumber, Double salary);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getEmployees();

    Map<String, Employee> getEmployeesMap();
}
