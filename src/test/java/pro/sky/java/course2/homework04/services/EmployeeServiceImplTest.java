package pro.sky.java.course2.homework04.services;

import org.junit.jupiter.api.*;
import pro.sky.java.course2.homework04.Employee;
import pro.sky.java.course2.homework04.exceptions.BadRequestException;
import pro.sky.java.course2.homework04.exceptions.EmployeeIsNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static pro.sky.java.course2.homework04.constants.EmployeeServiceConstants.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    private Employee employeeForTest;
    private Employee employeeForTest2;
    private final Map<String, Employee> employeesForTest = new HashMap<>();

    @BeforeEach
    public void createEmployeeForTest() {
        employeeForTest = new Employee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
        employeeForTest2 = new Employee(FIRST_NAME2, LAST_NAME2, DEP_NUMBER2, SALARY2);
        employeesForTest.put(LAST_NAME1 + FIRST_NAME1, employeeForTest);
        out.addEmployee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
    }


    @Test
    void shouldAddEmployee() {
//        out.addEmployee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
        Assertions.assertEquals(employeeForTest, out.findEmployee(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenEmployeeExists() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> out.addEmployee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1));
    }

    @Test
    void shouldThrowBadRequestExceptionWhenEmployeeFirstNameIsEmpty() {
        Assertions.assertThrows(BadRequestException.class,
                ()-> out.addEmployee(EMPTY_FIRST_NAME, LAST_NAME1, DEP_NUMBER1, SALARY1));
    }

    @Test
    void shouldRemoveEmployee() {
        out.removeEmployee(FIRST_NAME1, LAST_NAME1);
    }

    @Test
    void shouldThrowEmployeeIsNotFoundExceptionWhenRemovingEmployeeDoesNotExist() {
        Assertions.assertThrows(EmployeeIsNotFoundException.class,
                ()-> out.removeEmployee(FIRST_NAME2, LAST_NAME2));
    }

    @Test
    void shouldThrowBadRequestExceptionWhenRemovingEmployeeFirstNameIsEmpty() {
        Assertions.assertThrows(BadRequestException.class,
                ()-> out.removeEmployee(EMPTY_FIRST_NAME, LAST_NAME2));
    }

    @Test
    void shouldFindEmployee() {
        out.findEmployee(FIRST_NAME1, LAST_NAME1);
    }

    @Test
    void shouldThrowEmployeeIsNotFoundExceptionWhenEmployeeDoesNotExist() {
        Assertions.assertThrows(EmployeeIsNotFoundException.class,
                ()-> out.findEmployee(FIRST_NAME2, LAST_NAME2));
    }

    @Test
    void shouldGetEmployees() {
        Assertions.assertIterableEquals(employeesForTest.values(), out.getEmployees());
    }

    @Test
    void getEmployeesMap() {
        Assertions.assertEquals(employeesForTest, out.getEmployeesMap());
    }
}