package clickandcollect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testConstructorAndGetters() {
        Address address = new Address("123 Main St", "12345", "City");

        assertEquals("123 Main St", address.getAddress());
        assertEquals("12345", address.getZipCode());
        assertEquals("City", address.getCity());
    }

    @Test
    public void testEqualsAndHashCode() {
        Address address1 = new Address("123 Main St", "12345", "City");
        Address address2 = new Address("123 Main St", "12345", "City");
        Address address3 = new Address("456 Side St", "67890", "Town");

        assertEquals(address1, address2);
        assertNotEquals(address1, address3);
        assertEquals(address1.hashCode(), address2.hashCode());
        assertNotEquals(address1.hashCode(), address3.hashCode());
    }

    @Test
    public void testToString() {
        Address address = new Address("123 Main St", "12345", "City");

        assertEquals("123 Main St, 12345 City", address.toString());
    }
}
