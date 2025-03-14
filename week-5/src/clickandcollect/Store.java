package clickandcollect;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Store {
    private List<Order> orders;
    public static final double MINIMUM_ORDER_VALUE = 15.0;

    public Store() {
        orders = new ArrayList<>();
    }

    public boolean placeOrder(Order order) {
        if (order.getTotalValue() >= MINIMUM_ORDER_VALUE) {
            orders.add(order);
            return true;
        }
        return false;
    }

    public Order pickupOrder(String orderId, Customer customer) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId().equals(orderId) && order.getCustomer().equals(customer)) {
                iterator.remove();
                return order;
            }
        }
        return null;
    }

    public void removeOldOrders() {
        LocalDate today = LocalDate.now();
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (ChronoUnit.DAYS.between(order.getOrderDate(), today) >= 14) {
                iterator.remove();
            }
        }
    }

    public double getTotalValueOfOrders() {
        double total = 0;
        for (Order order : orders) {
            total += order.getTotalValue();
        }
        return total;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
