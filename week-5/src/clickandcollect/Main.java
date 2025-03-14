package clickandcollect;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Click and Collect System Demo");
        System.out.println("============================\n");

        Store store = new Store();

        Product laptop = new Product("Laptop", 899.99);
        Product phone = new Product("Smartphone", 499.99);
        Product headphones = new Product("Wireless Headphones", 129.99);
        Product charger = new Product("Fast Charger", 29.99);
        Product case1 = new Product("Phone Case", 19.99);

        Address address1 = new Address("123 Main Street", "12345", "Amsterdam");
        Address address2 = new Address("456 Oak Avenue", "67890", "Rotterdam");

        Customer alice = new Customer("Alice Johnson", address1);
        Customer bob = new Customer("Bob Smith", address2);

        Set<Product> aliceProducts = new HashSet<>();
        aliceProducts.add(laptop);
        aliceProducts.add(headphones);

        Order aliceOrder = new Order("ORD-001", alice, LocalDate.now(), aliceProducts);
        boolean aliceOrderPlaced = store.placeOrder(aliceOrder);

        System.out.println("Alice's order placed successfully: " + aliceOrderPlaced);
        System.out.println("Alice's order: " + aliceOrder);
        System.out.println("Alice's order value: €" + aliceOrder.getTotalValue());

        Set<Product> bobSmallProducts = new HashSet<>();
        bobSmallProducts.add(case1);

        Order bobSmallOrder = new Order("ORD-002", bob, LocalDate.now(), bobSmallProducts);
        boolean bobSmallOrderPlaced = store.placeOrder(bobSmallOrder);

        System.out.println("\nBob's small order placed successfully: " + bobSmallOrderPlaced);
        System.out.println("Bob's small order value: €" + bobSmallOrder.getTotalValue());
        System.out.println("Minimum order value required: €" + Store.MINIMUM_ORDER_VALUE);

        Set<Product> bobProducts = new HashSet<>();
        bobProducts.add(phone);
        bobProducts.add(charger);
        bobProducts.add(case1);

        Order bobOrder = new Order("ORD-003", bob, LocalDate.now(), bobProducts);
        boolean bobOrderPlaced = store.placeOrder(bobOrder);

        System.out.println("\nBob's regular order placed successfully: " + bobOrderPlaced);
        System.out.println("Bob's order: " + bobOrder);

        Set<Product> oldProducts = new HashSet<>();
        oldProducts.add(charger);
        oldProducts.add(case1);

        Order oldOrder = new Order("ORD-004", alice, LocalDate.now().minusDays(20), oldProducts);
        store.placeOrder(oldOrder);

        System.out.println("\nBefore cleanup - Number of orders in store: " + store.getOrders().size());
        store.removeOldOrders();
        System.out.println("After cleanup - Number of orders in store: " + store.getOrders().size());

        System.out.println("\nPickup Demo:");
        Order pickedOrder = store.pickupOrder("ORD-001", alice);
        if (pickedOrder != null) {
            System.out.println("Successfully picked up: " + pickedOrder);
        } else {
            System.out.println("Failed to pick up order");
        }

        Order wrongPickup = store.pickupOrder("ORD-003", alice);
        System.out.println("Attempt to pick up Bob's order by Alice successful: " + (wrongPickup != null));

        System.out.println("\nFinal store status:");
        System.out.println("Number of orders remaining: " + store.getOrders().size());
        System.out.println("Total value of orders: €" + store.getTotalValueOfOrders());
    }
}
