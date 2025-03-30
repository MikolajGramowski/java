package com.nhlstenden.hrm;

import java.time.LocalDate;
import java.util.ArrayList;

public class HRMDepartment
{
    private ArrayList<Employee> employees;

    public HRMDepartment(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }

    public Employee getEmployeeByNumber(int employeeNumber)
    {
        for (Employee employee : this.employees)
        {
            if (employee.getNumber() == employeeNumber)
            {
                return employee;
            }
        }
        return null;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        for (Employee employee : this.getEmployees()) {
            if (oldestEmployee == null || employee.getDateOfBirth().isBefore(oldestEmployee.getDateOfBirth())) {
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }


    public int getAverageNumberOfYearsOfService()
    {
        int totalYears = 0;
        for (Employee employee : this.employees)
        {
            totalYears += LocalDate.now().getYear() - employee.getDateOfHire().getYear();
        }
        return totalYears / this.employees.size();
    }
}
