package fire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class FireDepartmentTest {

    private FireDepartment department;
    private Firefighter senior1;
    private Firefighter senior2;
    private Firefighter senior3;
    private Firefighter senior4;
    private Firefighter senior5;
    private Firefighter junior;

    @BeforeEach
    public void setUp() {
        department = new FireDepartment();
        senior1 = new Firefighter("Senior1", LocalDate.now().minusYears(15));
        senior2 = new Firefighter("Senior2", LocalDate.now().minusYears(12));
        senior3 = new Firefighter("Senior3", LocalDate.now().minusYears(20));
        senior4 = new Firefighter("Senior4", LocalDate.now().minusYears(11));
        senior5 = new Firefighter("Senior5", LocalDate.now().minusYears(18));
        junior = new Firefighter("Junior", LocalDate.now().minusYears(5));
        department.addFirefighter(senior1);
        department.addFirefighter(senior2);
        department.addFirefighter(senior3);
        department.addFirefighter(senior4);
        department.addFirefighter(senior5);
        department.addFirefighter(junior);
        department.addFireTruck(new FireTruck("T001", 1000, 800, 5));
        department.addFireTruck(new FireTruck("T002", 1200, 600, 4));
    }

    @Test
    public void testInitialization() {
        assertEquals(6, department.getAvailableFirefighters().size());
        assertEquals(2, department.getAvailableTrucks().size());
        assertTrue(department.getEmergencies().isEmpty());
    }

    @Test
    public void testAddFirefighterAndTruck() {
        Firefighter newFirefighter = new Firefighter("New", LocalDate.now().minusYears(8));
        department.addFirefighter(newFirefighter);
        assertEquals(7, department.getAvailableFirefighters().size());
        FireTruck newTruck = new FireTruck("T003", 800, 800, 3);
        department.addFireTruck(newTruck);
        assertEquals(3, department.getAvailableTrucks().size());
    }

    @Test
    public void testReportEmergencyPriority1() {
        Emergency emergency = new Emergency("High Priority Fire", 1, 300);
        department.reportEmergency(emergency);
        assertEquals(1, department.getEmergencies().size());
        assertEquals(1, department.getAvailableTrucks().size());
        assertEquals(1, department.getAvailableFirefighters().size());
        assertEquals(5, emergency.getAssignedFirefighters().size());
        for (Firefighter ff : emergency.getAssignedFirefighters()) {
            assertTrue(ff.getYearsOfExperience() > 10);
        }
        assertEquals(500, emergency.getAssignedTruck().getCurrentWaterLevel());
    }

    @Test
    public void testReportEmergencyLowerPriority() {
        Emergency emergency = new Emergency("Low Priority Fire", 3, 200);
        department.reportEmergency(emergency);
        assertEquals(1, department.getEmergencies().size());
        assertNotNull(emergency.getAssignedTruck());
        assertFalse(emergency.getAssignedFirefighters().isEmpty());
    }

    @Test
    public void testCompleteEmergency() {
        Emergency emergency = new Emergency("Test Fire", 2, 300);
        department.reportEmergency(emergency);
        int initialAvailableFirefighters = department.getAvailableFirefighters().size();
        int initialAvailableTrucks = department.getAvailableTrucks().size();
        department.completeEmergency(emergency);
        assertTrue(emergency.isCompleted());
        assertEquals(initialAvailableFirefighters + emergency.getAssignedFirefighters().size(),
                department.getAvailableFirefighters().size());
        assertEquals(initialAvailableTrucks + 1, department.getAvailableTrucks().size());
    }

    @Test
    public void testReportEmergencyNotEnoughWater() {
        Emergency bigEmergency = new Emergency("Huge Fire", 2, 2000);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        department.reportEmergency(bigEmergency);
        System.setOut(System.out);
        assertTrue(department.getEmergencies().isEmpty());
        assertTrue(outContent.toString().contains("No available fire truck with enough water!"));
    }

    @Test
    public void testReportEmergencyPriority1NotEnoughSeniors() {
        FireDepartment smallDept = new FireDepartment();
        smallDept.addFirefighter(senior1);
        smallDept.addFirefighter(senior2);
        smallDept.addFirefighter(junior);
        smallDept.addFireTruck(new FireTruck("T001", 1000, 800, 5));
        Emergency emergency = new Emergency("Priority 1 Fire", 1, 300);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        smallDept.reportEmergency(emergency);
        System.setOut(System.out);
        assertTrue(smallDept.getEmergencies().isEmpty());
        assertTrue(outContent.toString().contains("Not enough experienced firefighters for a priority 1 emergency!"));
    }
}
