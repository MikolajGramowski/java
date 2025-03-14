package fire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FireTruckTest {

    private FireTruck truck;

    @BeforeEach
    public void setUp() {
        truck = new FireTruck("T001", 1000, 800, 5);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("T001", truck.getId());
        assertEquals(1000, truck.getMaxWaterCapacity());
        assertEquals(800, truck.getCurrentWaterLevel());
        assertEquals(5, truck.getCapacity());
        assertTrue(truck.getAssignedFirefighters().isEmpty());
    }

    @Test
    public void testHasEnoughWater() {
        assertTrue(truck.hasEnoughWater(500));
        assertTrue(truck.hasEnoughWater(800));
        assertFalse(truck.hasEnoughWater(801));
    }

    @Test
    public void testUseWater() {
        truck.useWater(300);
        assertEquals(500, truck.getCurrentWaterLevel());
        truck.useWater(600);
        assertEquals(0, truck.getCurrentWaterLevel());
    }

    @Test
    public void testRefill() {
        truck.useWater(500);
        assertEquals(300, truck.getCurrentWaterLevel());
        truck.refill();
        assertEquals(1000, truck.getCurrentWaterLevel());
    }

    @Test
    public void testAssignAndClearFirefighters() {
        List<Firefighter> firefighters = new ArrayList<>();
        firefighters.add(new Firefighter("Alice", LocalDate.now().minusYears(5)));
        firefighters.add(new Firefighter("Bob", LocalDate.now().minusYears(10)));
        truck.assignFirefighters(firefighters);
        assertEquals(2, truck.getAssignedFirefighters().size());
        truck.clearAssignments();
        assertTrue(truck.getAssignedFirefighters().isEmpty());
    }

    @Test
    public void testToString() {
        String expected = "FireTruck T001 (Water: 800/1000, Capacity: 5)";
        assertEquals(expected, truck.toString());
    }
}
