package pro.sky.java.course2.homework04;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    String key;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String firstName, String lastName) {
        key = lastName + firstName;
        return key;
    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsValue(employee)) {
            throw new IllegalArgumentException();
        } else {
            employees.put(getKey(firstName, lastName), employee);
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsValue(employee)) {
            employees.remove(key);
        } else {
            throw new EmployeeIsNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String key) {
        if (employees.containsKey(key)){
            return employees.get(key);
        }
        throw new EmployeeIsNotFoundException();
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

}
