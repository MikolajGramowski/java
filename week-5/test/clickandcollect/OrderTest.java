package clickandcollect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Customer customer;
    private Product product1;
    private Product product2;
    private Set<Product> productSet;
    private Order order;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", new Address("123 Main St", "12345", "New York"));
        product1 = new Product("P001", 1000.0);
        product2 = new Product("P002",  50.0);
        productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        order = new Order("O001", customer, LocalDate.of(2025, 3, 11), productSet);
    }

    @Test
    void testOrderCreation() {
        assertEquals("O001", order.getOrderId());
        assertEquals(customer, order.getCustomer());
        assertEquals(LocalDate.of(2025, 3, 11), order.getOrderDate());
        assertEquals(2, order.getProducts().size());
    }

    @Test
    void testGetTotalValue() {
        double expectedTotal = 1000.0 + 50.0 + Order.SERVICE_CHARGE;
        assertEquals(expectedTotal, order.getTotalValue(), 0.01);
    }

    @Test
    void testEmptyProductList() {
        Order emptyOrder = new Order("O002", customer, LocalDate.now(), new HashSet<>());
        assertEquals(Order.SERVICE_CHARGE, emptyOrder.getTotalValue(), 0.01);
    }

    @Test
    void testNullProductList() {
        Order nullOrder = new Order("O003", customer, LocalDate.now(), null);
        assertEquals(Order.SERVICE_CHARGE, nullOrder.getTotalValue(), 0.01);
        assertTrue(nullOrder.getProducts().isEmpty());
    }

    @Test
    void testToString() {
        String expectedString = "Order: O001 for John Doe on 2025-03-11, Total: 1052.5€";
        assertEquals(expectedString, order.toString());
    }
}