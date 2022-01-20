package pro.sky.java.course2.homework04.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework04.Employee;
import pro.sky.java.course2.homework04.exceptions.BadRequestException;
import pro.sky.java.course2.homework04.exceptions.EmployeeIsNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String firstName, String lastName) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        return lastName + firstName;
    }

    @Override
    public void addEmployee(String firstName, String lastName, Integer depNumber, Double salary) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
            Employee employee = new Employee(firstName, lastName, depNumber, salary);
            if (employees.containsKey(getKey(firstName, lastName))) {
                throw new IllegalArgumentException();
            } else {
                employees.put(getKey(firstName, lastName), employee);
            }
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            String key = getKey(firstName, lastName);
            if (employees.containsKey(key)) {
                employees.remove(key);
            } else {
                throw new EmployeeIsNotFoundException();
            }
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            if (employees.get(getKey(firstName, lastName)) == null) {
                throw new EmployeeIsNotFoundException();
            } else {
                return employees.get(getKey(firstName, lastName));
            }
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    @Override
    public Map<String, Employee> getEmployeesMap() {
        return employees;
    }

}
