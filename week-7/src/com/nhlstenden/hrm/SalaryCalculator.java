package com.nhlstenden.hrm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class SalaryCalculator
{
    private Employee employee;

    public SalaryCalculator(Employee employee)
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

    public BigDecimal getGrossSalary()
    {
        BigDecimal baseSalary = new BigDecimal(1500);
        for (HashMap.Entry<Integer, Performance> entry : this.getEmployee().getPerformance().entrySet())
        {
            if (entry.getValue() == Performance.Good)
            {
                baseSalary = baseSalary.multiply(new BigDecimal("1.023"));
            }
        }
        return baseSalary.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getNetSalary()
    {
        BigDecimal grossSalary = this.getGrossSalary();
        if (employee.isHasIncomeTaxCredit())
        {
            grossSalary = grossSalary.subtract(this.getGrossSalary().multiply(new BigDecimal("0.1")));
        } else {
            grossSalary = grossSalary.subtract(this.getGrossSalary().multiply(new BigDecimal("0.15")));
        }
        if (employee.isContributesToInsurances())
        {
            grossSalary = grossSalary.subtract(this.getGrossSalary().multiply(new BigDecimal("0.01")));
        }
        return grossSalary.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getBonus()
    {
        return getGrossSalary().multiply(new BigDecimal("0.08")).setScale(2, RoundingMode.HALF_UP);
    }
}
