package com.nhlstenden.hrm;

import java.time.LocalDate;
import java.util.HashMap;

public class Employee
{
    private String name;
    private int number;
    private LocalDate dateOfBirth;
    private LocalDate dateOfHire;
    // Integer = Year
    private HashMap<Integer, Performance> performance;
    private boolean hasIncomeTaxCredit;
    private boolean contributesToInsurances;

    public Employee(String name, int number, LocalDate dateOfBirth, LocalDate dateOfHire, HashMap<Integer, Performance> performance, boolean hasIncomeTaxCredit, boolean contributesToInsurances)
    {
        this.name = name;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
        this.dateOfHire = dateOfHire;
        this.performance = performance;
        this.hasIncomeTaxCredit = hasIncomeTaxCredit;
        this.contributesToInsurances = contributesToInsurances;
    }

    public boolean isContributesToInsurances()
    {
        return contributesToInsurances;
    }

    public void setContributesToInsurances(boolean contributesToInsurances)
    {
        this.contributesToInsurances = contributesToInsurances;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfHire()
    {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire)
    {
        this.dateOfHire = dateOfHire;
    }

    public HashMap<Integer, Performance> getPerformance()
    {
        return performance;
    }

    public void setPerformance(HashMap<Integer, Performance> performance)
    {
        this.performance = performance;
    }

    public boolean isHasIncomeTaxCredit()
    {
        return hasIncomeTaxCredit;
    }

    public void setHasIncomeTaxCredit(boolean hasIncomeTaxCredit)
    {
        this.hasIncomeTaxCredit = hasIncomeTaxCredit;
    }
}
