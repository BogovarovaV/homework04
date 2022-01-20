package pro.sky.java.course2.homework04.services;

import pro.sky.java.course2.homework04.Employee;

import java.util.List;

public interface DepartmentService {

    Employee getMaxSalaryPerDepartment(Integer departmentId);

    Employee getMinSalaryPerDepartment(Integer departmentId);

    List<Employee> getEmployeesPerDepartment(Integer departmentId);

    List<Employee> getAllEmployeesWithDepartments();
}
