package pro.sky.java.course2.homework04;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String firstName, String lastName) {
        return lastName + firstName;
    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(getKey(firstName, lastName))) {
            throw new IllegalArgumentException();
        } else {
            employees.put(getKey(firstName, lastName), employee);
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(getKey(firstName, lastName))) {
            employees.remove(getKey(firstName, lastName));
        } else {
            throw new EmployeeIsNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.get(getKey(firstName, lastName)) == null) {
            throw new EmployeeIsNotFoundException();
        } else {
            return employees.get(getKey(firstName, lastName));
        }
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

}
