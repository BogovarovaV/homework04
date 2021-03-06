package pro.sky.java.course2.homework04.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework04.Employee;
import pro.sky.java.course2.homework04.services.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam Integer depNumber,
                              @RequestParam Double salary) {
        employeeService.addEmployee(firstName, lastName, depNumber, salary);
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан.";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален.";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}
