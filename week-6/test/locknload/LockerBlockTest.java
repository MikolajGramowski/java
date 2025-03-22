package locknload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class LockerBlockTest
{

    private HashSet<Locker> lockers;
    private Laptop laptop1;
    private Laptop laptop2;
    private Laptop laptop3;
    private Locker locker1;
    private Locker locker2;
    private Locker locker3;
    private Locker emptyLocker1;
    private Locker emptyLocker2;

    @BeforeEach
    void setUp()
    {
        lockers = new HashSet<>();

        laptop1 = new Laptop("LP-001", 2500, 5000);
        laptop2 = new Laptop("LP-002", 4500, 5000);
        laptop3 = new Laptop("LP-003", 1200, 4000);

        locker1 = new Locker("L-101", laptop1);
        locker2 = new Locker("L-102", laptop2);
        locker3 = new Locker("L-103", laptop3);
        emptyLocker1 = new Locker("L-104", null);
        emptyLocker2 = new Locker("L-105", null);

        lockers.add(locker1);
        lockers.add(locker2);
        lockers.add(locker3);
        lockers.add(emptyLocker1);
        lockers.add(emptyLocker2);
    }

    @Test
    void constructor_validParameters_createsLockerBlockWithLockers()
    {
        LockerBlock lockerBlock = new LockerBlock(lockers);
        assertEquals(lockers, lockerBlock.getLockers());
        assertEquals(5, lockerBlock.getLockers().size());
    }

    @Test
    void setLockers_validSet_updatesLockers()
    {
        LockerBlock lockerBlock = new LockerBlock(new HashSet<>());
        assertTrue(lockerBlock.getLockers().isEmpty());

        lockerBlock.setLockers(lockers);
        assertEquals(lockers, lockerBlock.getLockers());
        assertEquals(5, lockerBlock.getLockers().size());
    }

    @Test
    void getAllAvailableLockers_mixedLockers_returnsOnlyEmptyLockers()
    {
        LockerBlock lockerBlock = new LockerBlock(lockers);
        HashSet<Locker> availableLockers = lockerBlock.getAllAvailableLockers();

        assertEquals(2, availableLockers.size());
        assertTrue(availableLockers.contains(emptyLocker1));
        assertTrue(availableLockers.contains(emptyLocker2));
    }

    @Test
    void getAllAvailableLockers_noEmptyLockers_returnsEmptySet()
    {
        HashSet<Locker> fullLockers = new HashSet<>();
        fullLockers.add(locker1);
        fullLockers.add(locker2);
        fullLockers.add(locker3);

        LockerBlock lockerBlock = new LockerBlock(fullLockers);
        HashSet<Locker> availableLockers = lockerBlock.getAllAvailableLockers();

        assertTrue(availableLockers.isEmpty());
    }

    @Test
    void getAvailableLocker_emptyLockersAvailable_returnsEmptyLocker()
    {
        LockerBlock lockerBlock = new LockerBlock(lockers);
        Locker availableLocker = lockerBlock.getAvailableLocker();

        assertNotNull(availableLocker);
        assertNull(availableLocker.getLaptop());
        assertTrue(availableLocker.getLockerNumber().equals("L-104") ||
                availableLocker.getLockerNumber().equals("L-105"));
    }

    @Test
    void getAvailableLocker_noEmptyLockers_returnsHighestChargedLocker()
    {
        HashSet<Locker> fullLockers = new HashSet<>();
        fullLockers.add(locker1);
        fullLockers.add(locker2);
        fullLockers.add(locker3);

        LockerBlock lockerBlock = new LockerBlock(fullLockers);
        Locker availableLocker = lockerBlock.getAvailableLocker();

        assertEquals("L-102", availableLocker.getLockerNumber());
    }

    @Test
    void getAvailableLocker_tiedBatteryPercentage_returnsHigherAbsoluteChargeLocker()
    {
        Laptop laptopTie1 = new Laptop("LP-T1", 3000, 6000);
        Laptop laptopTie2 = new Laptop("LP-T2", 1500, 3000);

        Locker lockerTie1 = new Locker("L-T1", laptopTie1);
        Locker lockerTie2 = new Locker("L-T2", laptopTie2);

        HashSet<Locker> tieLockers = new HashSet<>();
        tieLockers.add(lockerTie1);
        tieLockers.add(lockerTie2);

        LockerBlock lockerBlock = new LockerBlock(tieLockers);
        Locker availableLocker = lockerBlock.getAvailableLocker();

        assertEquals("L-T1", availableLocker.getLockerNumber());
    }

    @Test
    void calculateTotalChargingTime_mixedCharges_returnsCorrectTime()
    {
        LockerBlock lockerBlock = new LockerBlock(lockers);
        double expectedTime = 5800.0 / 522.0;
        assertEquals(expectedTime, lockerBlock.calculateTotalChargingTime(), 0.001);
    }

    @Test
    void calculateTotalChargingTime_noLaptops_returnsZero()
    {
        HashSet<Locker> emptyLockers = new HashSet<>();
        emptyLockers.add(emptyLocker1);
        emptyLockers.add(emptyLocker2);

        LockerBlock lockerBlock = new LockerBlock(emptyLockers);
        assertEquals(0.0, lockerBlock.calculateTotalChargingTime(), 0.001);
    }

    @Test
    void calculateTotalChargingTime_fullyChargedLaptops_returnsZero()
    {
        Laptop fullyCharged = new Laptop("LP-FULL", 5000, 5000);
        Locker chargedLocker = new Locker("L-FULL", fullyCharged);

        HashSet<Locker> chargedLockers = new HashSet<>();
        chargedLockers.add(chargedLocker);

        LockerBlock lockerBlock = new LockerBlock(chargedLockers);
        assertEquals(0.0, lockerBlock.calculateTotalChargingTime(), 0.001);
    }
}
