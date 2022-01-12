package pro.sky.java.course2.homework04.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework04.DepartmentService;
import pro.sky.java.course2.homework04.Employee;

import java.util.List;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryPerDepartment(@RequestParam Integer departmentId) {
        return departmentService.getMaxSalaryPerDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryPerDepartment(@RequestParam Integer departmentId) {
        return departmentService.getMinSalaryPerDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesPerDepartment(Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getEmployeesPerDepartment(departmentId);
        }
        return departmentService.getAllEmployeesWithDepartments();
    }

}
