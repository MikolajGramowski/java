package com.nhlstenden.hrm;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class VacationCalculator
{
    private Employee employee;

    public VacationCalculator(Employee employee)
    {
        this.employee = employee;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public int getVacationDays()
    {
        int baseVacationDays = (int) Character.getNumericValue(String.valueOf(this.employee.getNumber()).charAt(0)) == 1 ? 24 : 20;
        int age = Period.between(this.employee.getDateOfBirth(), LocalDate.now()).getYears();

        if (age > 55)
        {
            baseVacationDays += 5;
        }

        int hiredTime = Period.between(this.employee.getDateOfHire(), LocalDate.now()).getYears();
        if (hiredTime > 10)
        {
            baseVacationDays += 3;
        }
        return baseVacationDays;
    }
}
