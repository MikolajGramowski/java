package clickandcollect;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private String orderId;
    private Customer customer;
    private LocalDate orderDate;
    private Set<Product> products;
    public static final double SERVICE_CHARGE = 2.50;

    public Order(String orderId, Customer customer, LocalDate orderDate, Set<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.products = products != null ? products : new HashSet<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public double getTotalValue() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum + SERVICE_CHARGE;
    }

    @Override
    public String toString() {
        return "Order: " + orderId + " for " + customer.getName() + " on " + orderDate + ", Total: " + getTotalValue()
                + "€";
    }
}
