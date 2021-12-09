package pro.sky.java.course2.homework04;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Set<Employee> employees = new HashSet<>();

    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)){
            throw new EmployeeIsNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            return employee;
        }
        throw new EmployeeIsNotFoundException();
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(employees);
    }



}
