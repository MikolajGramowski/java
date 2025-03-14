package clickandcollect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Laptop", 999.99);
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice(), 0.001);
    }

    @Test
    public void testToString() {
        Product product = new Product("Mouse", 25.50);
        assertEquals("Product: Mouse (25.5€)", product.toString());
    }
}
