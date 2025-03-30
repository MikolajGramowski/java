package com.nhlstenden.hrm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting HRM System Test");
        System.out.println("=======================\n");

        // Create performance records for employees
        HashMap<Integer, Performance> johnPerformance = new HashMap<>();
        johnPerformance.put(2020, Performance.Good);
        johnPerformance.put(2021, Performance.Good);
        johnPerformance.put(2022, Performance.Neutral);

        HashMap<Integer, Performance> janePerformance = new HashMap<>();
        janePerformance.put(2020, Performance.Neutral);
        janePerformance.put(2021, Performance.Good);
        janePerformance.put(2022, Performance.Good);

        HashMap<Integer, Performance> bobPerformance = new HashMap<>();
        bobPerformance.put(2021, Performance.Good);
        bobPerformance.put(2022, Performance.Good);

        // Create employees
        Employee john = new Employee("John Doe", 101,
                LocalDate.of(1980, 5, 15),
                LocalDate.of(2010, 3, 10),
                johnPerformance, true, true);

        Employee jane = new Employee("Jane Smith", 202,
                LocalDate.of(1965, 7, 22),
                LocalDate.of(2008, 11, 5),
                janePerformance, false, true);

        Employee bob = new Employee("Bob Johnson", 303,
                LocalDate.of(1990, 12, 3),
                LocalDate.of(2021, 6, 1),
                bobPerformance, true, false);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(jane);
        employees.add(bob);
        HRMDepartment hrm = new HRMDepartment(employees);

        System.out.println("HRMDepartment Tests:");
        System.out.println("-----------------");

        int searchNumber = 202;
        Employee found = hrm.getEmployeeByNumber(searchNumber);
        System.out.println("Employee with number " + searchNumber + ": " +
                (found != null ? found.getName() : "Not found"));

        Employee oldest = hrm.getOldestEmployee();
        System.out.println("Oldest employee: " + oldest.getName() +
                " (DOB: " + oldest.getDateOfBirth() + ")");

        int avgYears = hrm.getAverageNumberOfYearsOfService();
        System.out.println("Average years of service: " + avgYears);

        System.out.println();
        System.out.println("VacationCalculator Tests:");
        System.out.println("----------------------");

        VacationCalculator vacCalcJohn = new VacationCalculator(john);
        VacationCalculator vacCalcJane = new VacationCalculator(jane);

        System.out.println(john.getName() + "'s vacation days: " + vacCalcJohn.getVacationDays());
        System.out.println(jane.getName() + "'s vacation days: " + vacCalcJane.getVacationDays() +
                " (should include age bonus)");

        System.out.println();

        System.out.println("SalaryCalculator Tests:");
        System.out.println("--------------------");

        SalaryCalculator salCalcJohn = new SalaryCalculator(john);
        SalaryCalculator salCalcJane = new SalaryCalculator(jane);
        SalaryCalculator salCalcBob = new SalaryCalculator(bob);

        System.out.println(john.getName() + "'s gross salary: €" + salCalcJohn.getGrossSalary());
        System.out.println(john.getName() + "'s net salary: €" + salCalcJohn.getNetSalary() +
                " (with income tax credit and insurance)");
        System.out.println(john.getName() + "'s bonus: €" + salCalcJohn.getBonus());

        System.out.println(jane.getName() + "'s gross salary: €" + salCalcJane.getGrossSalary());
        System.out.println(jane.getName() + "'s net salary: €" + salCalcJane.getNetSalary() +
                " (without income tax credit, with insurance)");

        System.out.println(bob.getName() + "'s net salary: €" + salCalcBob.getNetSalary() +
                " (with income tax credit, without insurance)");

        System.out.println("\nAll tests completed!");
    }
}
