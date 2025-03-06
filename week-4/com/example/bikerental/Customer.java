package com.example.bikerental;

import java.time.LocalDate;
import java.time.Period;

public class Customer {
    private String name;
    private LocalDate dateOfBirth;

    public Customer(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        if (!isOldEnough()) {
            throw new IllegalArgumentException("Customer must be at least 16 years old.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private boolean isOldEnough() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= 16;
    }

    @Override
    public String toString() {
        return String.format("Customer{name='%s', dateOfBirth=%s}", name, dateOfBirth);
    }
}
