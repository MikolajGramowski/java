package fire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FirefighterTest {

    @Test
    public void testConstructorAndGetters() {
        LocalDate startDate = LocalDate.of(2010, 5, 15);
        Firefighter firefighter = new Firefighter("John Smith", startDate);

        assertEquals("John Smith", firefighter.getName());
        assertEquals(startDate, firefighter.getStartDate());
    }

    @Test
    public void testGetYearsOfExperience() {
        LocalDate startDate = LocalDate.now().minusYears(12);
        Firefighter firefighter = new Firefighter("Jane Doe", startDate);

        assertEquals(12, firefighter.getYearsOfExperience());
    }

    @Test
    public void testToString() {
        LocalDate startDate = LocalDate.now().minusYears(5);
        Firefighter firefighter = new Firefighter("Bob Johnson", startDate);

        assertEquals("Bob Johnson (5 years)", firefighter.toString());
    }
}