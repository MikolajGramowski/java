package com.nhlstenden.hrm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class VacationCalculatorTest {

    private Employee youngEmployee;
    private Employee seniorEmployee;
    private Employee longEmployedEmployee;
    private Employee employeeWithHighNumber;
    private VacationCalculator calculator;

    @BeforeEach
    public void setUp() {
        youngEmployee = new Employee("Young Employee", 201,
                LocalDate.of(1990, 1, 1),
                LocalDate.now().minusYears(5),
                new HashMap<>(), true, true);

        seniorEmployee = new Employee("Senior Employee", 202,
                LocalDate.now().minusYears(60),
                LocalDate.now().minusYears(5),
                new HashMap<>(), true, true);

        longEmployedEmployee = new Employee("Long Employed", 203,
                LocalDate.of(1980, 1, 1),
                LocalDate.now().minusYears(15),
                new HashMap<>(), true, true);

        employeeWithHighNumber = new Employee("High Number", 101,
                LocalDate.of(1985, 1, 1),
                LocalDate.now().minusYears(5),
                new HashMap<>(), true, true);

        calculator = new VacationCalculator(null);
    }

    @Test
    public void testGetVacationDaysForYoungEmployee() {
        calculator.setEmployee(youngEmployee);
        assertEquals(20, calculator.getVacationDays());
    }

    @Test
    public void testGetVacationDaysForSeniorEmployee() {
        calculator.setEmployee(seniorEmployee);
        assertEquals(25, calculator.getVacationDays());
    }

    @Test
    public void testGetVacationDaysForLongEmployedEmployee() {
        calculator.setEmployee(longEmployedEmployee);
        assertEquals(23, calculator.getVacationDays());
    }

    @Test
    public void testGetVacationDaysForEmployeeWithNumberStartingWith1() {
        calculator.setEmployee(employeeWithHighNumber);
        assertEquals(24, calculator.getVacationDays());
    }

    @Test
    public void testGetVacationDaysForSeniorLongEmployedEmployee() {
        Employee seniorLongEmployed = new Employee("Senior Long Employed", 204,
                LocalDate.now().minusYears(60),
                LocalDate.now().minusYears(15),
                new HashMap<>(), true, true);

        calculator.setEmployee(seniorLongEmployed);
        assertEquals(28, calculator.getVacationDays());
    }
}