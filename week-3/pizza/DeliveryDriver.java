package pizza;

import java.time.LocalDate;
import java.time.Period;

class DeliveryDriver {
    private String name;
    private LocalDate birthDate;

    public DeliveryDriver(String name, LocalDate birthDate) {
        if (calculateAge(birthDate) < 16) {
            throw new IllegalArgumentException("Driver must be at least 16 years old.");
        }
        this.name = name;
        this.birthDate = birthDate;
    }

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public double getSalaryPerRoute() {
        int age = calculateAge(birthDate);
        if (age < 20)
            return 4.0;
        else if (age <= 22)
            return 4.75;
        else
            return 5.25;
    }
}