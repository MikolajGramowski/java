package com.nhlstenden.hrm;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructorAndProperties() {
        String name = "Test Employee";
        int number = 101;
        LocalDate dob = LocalDate.of(1990, 5, 15);
        LocalDate hireDate = LocalDate.of(2018, 3, 10);
        HashMap<Integer, Performance> performance = new HashMap<>();
        performance.put(2021, Performance.Good);
        boolean hasIncomeTaxCredit = true;
        boolean contributesToInsurances = false;

        Employee employee = new Employee(name, number, dob, hireDate,
                performance, hasIncomeTaxCredit, contributesToInsurances);

        assertEquals(name, employee.getName());
        assertEquals(number, employee.getNumber());
        assertEquals(dob, employee.getDateOfBirth());
        assertEquals(hireDate, employee.getDateOfHire());
        assertEquals(performance, employee.getPerformance());
        assertTrue(employee.isHasIncomeTaxCredit());
        assertFalse(employee.isContributesToInsurances());
    }

    @Test
    public void testEmployeeSetters() {
        Employee employee = new Employee("Initial Name", 100,
                LocalDate.of(1980, 1, 1),
                LocalDate.of(2010, 1, 1),
                new HashMap<>(), false, false);

        String newName = "Updated Name";
        int newNumber = 200;
        LocalDate newDob = LocalDate.of(1985, 5, 5);
        LocalDate newHireDate = LocalDate.of(2015, 5, 5);
        HashMap<Integer, Performance> newPerformance = new HashMap<>();
        newPerformance.put(2022, Performance.Good);

        employee.setName(newName);
        employee.setNumber(newNumber);
        employee.setDateOfBirth(newDob);
        employee.setDateOfHire(newHireDate);
        employee.setPerformance(newPerformance);
        employee.setHasIncomeTaxCredit(true);
        employee.setContributesToInsurances(true);

        assertEquals(newName, employee.getName());
        assertEquals(newNumber, employee.getNumber());
        assertEquals(newDob, employee.getDateOfBirth());
        assertEquals(newHireDate, employee.getDateOfHire());
        assertEquals(newPerformance, employee.getPerformance());
        assertTrue(employee.isHasIncomeTaxCredit());
        assertTrue(employee.isContributesToInsurances());
    }
}