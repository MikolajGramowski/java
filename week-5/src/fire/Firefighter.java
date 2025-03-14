package fire;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Firefighter {
    private String name;
    private LocalDate startDate;

    public Firefighter(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public long getYearsOfExperience() {
        return ChronoUnit.YEARS.between(startDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return name + " (" + getYearsOfExperience() + " years)";
    }
}
