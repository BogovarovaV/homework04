package pro.sky.java.course2.homework04.services;

import org.junit.jupiter.api.*;
import pro.sky.java.course2.homework04.Employee;
import pro.sky.java.course2.homework04.exceptions.BadRequestException;
import pro.sky.java.course2.homework04.exceptions.EmployeeIsNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.homework04.constants.EmployeeServiceConstants.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    private Employee employeeForTest;
    private final Map<String, Employee> employeesForTest = new HashMap<>();

    @BeforeEach
    public void createEmployeeForTest() {
        employeeForTest = new Employee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
        employeesForTest.put(LAST_NAME1 + FIRST_NAME1, employeeForTest);
        out.addEmployee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
    }


    @Test
    void shouldAddEmployee() {
//        out.addEmployee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1);
        assertEquals(employeeForTest, out.findEmployee(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenEmployeeExists() {
        assertThrows(IllegalArgumentException.class,
                ()-> out.addEmployee(FIRST_NAME1, LAST_NAME1, DEP_NUMBER1, SALARY1));
    }

    @Test
    void shouldThrowBadRequestExceptionWhenEmployeeFirstNameIsEmpty() {
        assertThrows(BadRequestException.class,
                ()-> out.addEmployee(EMPTY_FIRST_NAME, LAST_NAME1, DEP_NUMBER1, SALARY1));
    }

    @Test
    void shouldDoesNotThrowExceptionAndRemoveEmployee() {
        assertDoesNotThrow(()-> out.removeEmployee(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    void shouldThrowEmployeeIsNotFoundExceptionWhenRemovingEmployeeDoesNotExist() {
        assertThrows(EmployeeIsNotFoundException.class,
                ()-> out.removeEmployee(FIRST_NAME2, LAST_NAME2));
    }

    @Test
    void shouldThrowBadRequestExceptionWhenRemovingEmployeeFirstNameIsEmpty() {
        assertThrows(BadRequestException.class,
                ()-> out.removeEmployee(EMPTY_FIRST_NAME, LAST_NAME2));
    }

    @Test
    void shouldFindEmployee() {
        assertEquals(employeeForTest, out.findEmployee(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    void shouldThrowEmployeeIsNotFoundExceptionWhenEmployeeDoesNotExist() {
        assertThrows(EmployeeIsNotFoundException.class,
                ()-> out.findEmployee(FIRST_NAME2, LAST_NAME2));
    }

    @Test
    void shouldGetEmployees() {
        assertIterableEquals(employeesForTest.values(), out.getEmployees());
    }

    @Test
    void getEmployeesMap() {
        assertEquals(employeesForTest, out.getEmployeesMap());
    }
}