package com.nhlstenden.hrm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class HRMDepartmentTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private HRMDepartment hrmDepartment;

    @BeforeEach
    public void setUp() {
        HashMap<Integer, Performance> perf1 = new HashMap<>();
        perf1.put(2020, Performance.Good);
        employee1 = new Employee("John Doe", 101,
                LocalDate.of(1990, 5, 10),
                LocalDate.of(2015, 6, 15),
                perf1, true, true);

        HashMap<Integer, Performance> perf2 = new HashMap<>();
        perf2.put(2020, Performance.Neutral);
        employee2 = new Employee("Jane Smith", 102,
                LocalDate.of(1980, 3, 5),
                LocalDate.of(2010, 1, 1),
                perf2, false, true);

        HashMap<Integer, Performance> perf3 = new HashMap<>();
        perf3.put(2021, Performance.Good);
        employee3 = new Employee("Bob Johnson", 103,
                LocalDate.of(1985, 12, 15),
                LocalDate.of(2018, 9, 10),
                perf3, true, false);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        hrmDepartment = new HRMDepartment(employees);
    }

    @Test
    public void testGetEmployeeByNumber() {
        assertEquals(employee1, hrmDepartment.getEmployeeByNumber(101));
        assertEquals(employee2, hrmDepartment.getEmployeeByNumber(102));
        assertEquals(employee3, hrmDepartment.getEmployeeByNumber(103));
        assertNull(hrmDepartment.getEmployeeByNumber(999));
    }

    @Test
    public void testGetOldestEmployee() {
        Employee oldest = hrmDepartment.getOldestEmployee();
        assertEquals(employee2, oldest);
    }

    @Test
    public void testGetAverageNumberOfYearsOfService() {
        int currentYear = LocalDate.now().getYear();
        int expectedTotalYears = (currentYear - 2015) + (currentYear - 2010) + (currentYear - 2018);
        int expectedAverage = expectedTotalYears / 3;
        int actualAverage = hrmDepartment.getAverageNumberOfYearsOfService();
        assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void testSetEmployees() {
        ArrayList<Employee> newEmployees = new ArrayList<>();
        newEmployees.add(employee1);
        hrmDepartment.setEmployees(newEmployees);
        assertEquals(1, hrmDepartment.getEmployees().size());
        assertEquals(employee1, hrmDepartment.getEmployees().get(0));
    }
}
