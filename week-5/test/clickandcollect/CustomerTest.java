package clickandcollect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testConstructorAndGetters() {
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        assertEquals("John Doe", customer.getName());
        assertEquals(address, customer.getAddress());
    }

    @Test
    public void testEqualsAndHashCode() {
        Address address1 = new Address("123 Main St", "12345", "City");
        Address address2 = new Address("123 Main St", "12345", "City");
        Address address3 = new Address("456 Side St", "67890", "Town");

        Customer customer1 = new Customer("John Doe", address1);
        Customer customer2 = new Customer("John Doe", address2);
        Customer customer3 = new Customer("Jane Doe", address1);
        Customer customer4 = new Customer("John Doe", address3);

        assertEquals(customer1, customer2);
        assertNotEquals(customer1, customer3);
        assertNotEquals(customer1, customer4);
        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertNotEquals(customer1.hashCode(), customer3.hashCode());
    }

    @Test
    public void testToString() {
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        assertEquals("Customer: John Doe, 123 Main St, 12345 City", customer.toString());
    }
}
