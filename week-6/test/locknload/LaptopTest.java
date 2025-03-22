package locknload;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaptopTest
{

    @Test
    void constructor_validParameters_createsLaptopSuccessfully()
    {
        Laptop laptop = new Laptop("LP-001", 2500, 5000);
        assertEquals("LP-001", laptop.getSerialNumber());
        assertEquals(2500, laptop.getCurrentCharge());
        assertEquals(5000, laptop.getBatteryCapacity());
    }

    @Test
    void constructor_chargeGreaterThanCapacity_throwsIllegalArgumentException()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Laptop("LP-001", 6000, 5000));
        assertEquals("Current charge cannot be greater than battery capacity.", exception.getMessage());
    }

    @Test
    void constructor_negativeCharge_throwsIllegalArgumentException()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Laptop("LP-001", -100, 5000));
        assertEquals("Current charge cannot be negative.", exception.getMessage());
    }

    @Test
    void constructor_zeroCapacity_throwsIllegalArgumentException()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Laptop("LP-001", 0, 0));
        assertEquals("Battery capacity must be greater than zero.", exception.getMessage());
    }

    @Test
    void setters_validValues_properlyUpdatesFields()
    {
        Laptop laptop = new Laptop("LP-001", 2500, 5000);

        laptop.setSerialNumber("LP-999");
        assertEquals("LP-999", laptop.getSerialNumber());

        laptop.setCurrentCharge(3000);
        assertEquals(3000, laptop.getCurrentCharge());

        laptop.setBatteryCapacity(6000);
        assertEquals(6000, laptop.getBatteryCapacity());
    }

    @Test
    void calculateCurrentBatteryPercentage_variousCharges_returnsCorrectPercentage()
    {
        Laptop laptop = new Laptop("LP-001", 2500, 5000);
        assertEquals(50.0, laptop.calculateCurrentBatteryPercentage(), 0.001);

        Laptop fullLaptop = new Laptop("LP-002", 5000, 5000);
        assertEquals(100.0, fullLaptop.calculateCurrentBatteryPercentage(), 0.001);

        Laptop lowLaptop = new Laptop("LP-003", 250, 5000);
        assertEquals(5.0, lowLaptop.calculateCurrentBatteryPercentage(), 0.001);
    }
}