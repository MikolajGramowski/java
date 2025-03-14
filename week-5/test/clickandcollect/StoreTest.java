package clickandcollect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class StoreTest {

    @Test
    public void testPlaceOrderWithMinimumAmount() {
        Store store = new Store();
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        Set<Product> products = new HashSet<>();
        products.add(new Product("Product1", 7.5));
        products.add(new Product("Product2", 5.0));

        Order order = new Order("order1", customer, LocalDate.now(), products);
        boolean placed = store.placeOrder(order);
        assertTrue(placed);
        assertEquals(1, store.getOrders().size());
    }

    @Test
    public void testPlaceOrderBelowMinimumAmount() {
        Store store = new Store();
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        Set<Product> products = new HashSet<>();
        products.add(new Product("Product1", 5.0));
        products.add(new Product("Product2", 5.0));

        Order order = new Order("order2", customer, LocalDate.now(), products);
        boolean placed = store.placeOrder(order);
        assertFalse(placed);
        assertEquals(0, store.getOrders().size());
    }

    @Test
    public void testPickupOrderSuccess() {
        Store store = new Store();
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        Set<Product> products = new HashSet<>();
        products.add(new Product("Product1", 10.0));
        products.add(new Product("Product2", 5.0));
        Order order = new Order("order3", customer, LocalDate.now(), products);
        store.placeOrder(order);

        Order pickedUp = store.pickupOrder("order3", customer);
        assertNotNull(pickedUp);
        assertEquals("order3", pickedUp.getOrderId());
        assertEquals(0, store.getOrders().size());
    }

    @Test
    public void testPickupOrderFailureWrongCustomer() {
        Store store = new Store();
        Address address1 = new Address("123 Main St", "12345", "City");
        Customer customer1 = new Customer("John Doe", address1);
        Address address2 = new Address("456 Side St", "67890", "Town");
        Customer customer2 = new Customer("Jane Smith", address2);

        Set<Product> products = new HashSet<>();
        products.add(new Product("Product1", 10.0));
        products.add(new Product("Product2", 5.0));
        Order order = new Order("order4", customer1, LocalDate.now(), products);
        store.placeOrder(order);

        Order pickedUp = store.pickupOrder("order4", customer2);
        assertNull(pickedUp);
        assertEquals(1, store.getOrders().size());
    }

    @Test
    public void testRemoveOldOrders() {
        Store store = new Store();
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        Set<Product> products = new HashSet<>();
        products.add(new Product("Product1", 10.0));
        products.add(new Product("Product2", 5.0));

        Order oldOrder = new Order("order5", customer, LocalDate.now().minusDays(15), products);
        store.placeOrder(oldOrder);

        Order recentOrder = new Order("order6", customer, LocalDate.now().minusDays(10), products);
        store.placeOrder(recentOrder);

        store.removeOldOrders();
        assertEquals(1, store.getOrders().size());
        assertEquals("order6", store.getOrders().get(0).getOrderId());
    }

    @Test
    public void testTotalValueOfOrders() {
        Store store = new Store();
        Address address = new Address("123 Main St", "12345", "City");
        Customer customer = new Customer("John Doe", address);

        Set<Product> products1 = new HashSet<>();
        products1.add(new Product("Product1", 10.0));
        products1.add(new Product("Product2", 5.0));
        Order order1 = new Order("order7", customer, LocalDate.now(), products1);
        store.placeOrder(order1);

        Set<Product> products2 = new HashSet<>();
        products2.add(new Product("Product3", 20.0));
        Order order2 = new Order("order8", customer, LocalDate.now(), products2);
        store.placeOrder(order2);

        double totalValue = store.getTotalValueOfOrders();
        assertEquals(17.5 + 22.5, totalValue, 0.001);
    }
}
