package fire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmergencyTest {

    private Emergency emergency;

    @BeforeEach
    public void setUp() {
        emergency = new Emergency("House Fire", 2, 300);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("House Fire", emergency.getDescription());
        assertEquals(2, emergency.getPriority());
        assertEquals(300, emergency.getEstimatedWaterNeeded());
        assertFalse(emergency.isCompleted());
    }

    @Test
    public void testComplete() {
        assertFalse(emergency.isCompleted());

        emergency.complete();
        assertTrue(emergency.isCompleted());
    }

    @Test
    public void testAssignTruck() {
        FireTruck truck = new FireTruck("T001", 1000, 800, 5);
        assertNull(emergency.getAssignedTruck());

        emergency.assignTruck(truck);
        assertEquals(truck, emergency.getAssignedTruck());
    }

    @Test
    public void testAssignFirefighters() {
        List<Firefighter> firefighters = new ArrayList<>();
        firefighters.add(new Firefighter("Alice", LocalDate.now().minusYears(5)));
        firefighters.add(new Firefighter("Bob", LocalDate.now().minusYears(10)));

        assertNull(emergency.getAssignedFirefighters());

        emergency.assignFirefighters(firefighters);
        assertEquals(firefighters, emergency.getAssignedFirefighters());
        assertEquals(2, emergency.getAssignedFirefighters().size());
    }

    @Test
    public void testToString() {
        String expected = "Emergency: House Fire [Priority: 2, Estimated Water: 300, Status: Active]";
        assertEquals(expected, emergency.toString());

        emergency.complete();
        expected = "Emergency: House Fire [Priority: 2, Estimated Water: 300, Status: Completed]";
        assertEquals(expected, emergency.toString());
    }
}