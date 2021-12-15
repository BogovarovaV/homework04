package pro.sky.java.course2.homework04;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getEmployees();
}
