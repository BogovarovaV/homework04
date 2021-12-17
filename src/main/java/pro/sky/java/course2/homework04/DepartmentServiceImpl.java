package pro.sky.java.course2.homework04;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Stream<Employee> getEmployeeList() {
        return employeeService.getEmployees().stream();
    }

    @Override
    public Employee getMaxSalaryPerDepartment(Integer departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepNumber() == departmentId)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    @Override
    public Employee getMinSalaryPerDepartment(Integer departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepNumber() == departmentId)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    @Override
    public List<Employee> getEmployeesPerDepartment(Integer departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepNumber() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeesWithDepartments() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepNumber()))
                .collect(Collectors.toList());
    }


}
