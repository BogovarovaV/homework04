package pro.sky.java.course2.homework04.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.homework04.Employee;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.homework04.constants.EmployeeServiceConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceImplMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    private final Employee employee1 = new Employee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
    private final Employee employee2 = new Employee(FIRST_NAME2, LAST_NAME2, DEP_NUMBER1, SALARY2);
    private final Employee employee3 = new Employee(FIRST_NAME3, LAST_NAME3, DEP_NUMBER1, SALARY3);



    @BeforeEach
    public void setUp() {
        Mockito.when(employeeServiceImplMock.getEmployees()).thenReturn(List.of(employee1, employee2, employee3));
    }

    @Test
    void shouldFindEmployeeWithMaxSalaryPerDepartment() {
        Employee actualEmployee = out.getMaxSalaryPerDepartment(DEP_NUMBER1);
        assertEquals(employee2, actualEmployee);
    }

    @Test
    void shouldFindEmployeeWithMinSalaryPerDepartment() {
        Employee actualEmployee = out.getMinSalaryPerDepartment(DEP_NUMBER1);
        assertEquals(employee1, actualEmployee);
    }

    @Test
    void shouldGetEmployeesPerDepartment() {
        Collection<Employee> actualEmployeesPerDepartment = out.getEmployeesPerDepartment(DEP_NUMBER1);
        List<Employee> expectedEmployeesPerDepartment = List.of(employee1, employee2, employee3);
        assertEquals(expectedEmployeesPerDepartment.size(), actualEmployeesPerDepartment.size());
        assertTrue(expectedEmployeesPerDepartment.containsAll(actualEmployeesPerDepartment));
    }

    @Test
    void shouldGetAllEmployeesWithDepartments() {
        List<Employee> actualAllEmployees = out.getAllEmployeesWithDepartments();
        List<Employee> expectedAllEmployee = List.of(employee1, employee2, employee3);
        assertEquals(expectedAllEmployee.size(), actualAllEmployees.size());
        assertTrue(expectedAllEmployee.containsAll(actualAllEmployees));
    }
}