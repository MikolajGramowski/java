package locknload;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest
{

    @Test
    void constructor_withLaptop_createsLockerWithLaptop()
    {
        Laptop laptop = new Laptop("LP-001", 2500, 5000);
        Locker locker = new Locker("L-101", laptop);

        assertEquals("L-101", locker.getLockerNumber());
        assertSame(laptop, locker.getLaptop());
    }

    @Test
    void constructor_withoutLaptop_createsEmptyLocker()
    {
        Locker locker = new Locker("L-101", null);

        assertEquals("L-101", locker.getLockerNumber());
        assertNull(locker.getLaptop());
    }

    @Test
    void setLockerNumber_validNumber_updatesNumber()
    {
        Locker locker = new Locker("L-101", null);
        locker.setLockerNumber("L-999");

        assertEquals("L-999", locker.getLockerNumber());
    }

    @Test
    void setLaptop_laptopOrNull_updatesOrRemovesLaptop()
    {
        Locker locker = new Locker("L-101", null);
        Laptop laptop = new Laptop("LP-001", 2500, 5000);

        assertNull(locker.getLaptop());
        locker.setLaptop(laptop);
        assertSame(laptop, locker.getLaptop());

        Laptop newLaptop = new Laptop("LP-002", 3000, 5000);
        locker.setLaptop(newLaptop);
        assertSame(newLaptop, locker.getLaptop());

        locker.setLaptop(null);
        assertNull(locker.getLaptop());
    }
}
