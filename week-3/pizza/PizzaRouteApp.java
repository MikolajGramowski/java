package pizza;

import java.time.LocalDate;

public class PizzaRouteApp {
    public static void main(String[] args) {
        DeliveryDriver driver1 = new DeliveryDriver("John Doe", LocalDate.of(2003, 5, 15));
        DeliveryDriver driver2 = new DeliveryDriver("John Boe", LocalDate.of(1998, 8, 22));

        Route route1 = new Route("Route A", driver1);
        Route route2 = new Route("Route B", driver2);

        route1.addDestination(new Destination("Customer 1", "Street 1", 5.0, 4));
        route1.addDestination(new Destination("Customer 2", "Street 2", 3.0, 2));

        route2.addDestination(new Destination("Customer 3", "Street 3", 10.0, 6));
        route2.addDestination(new Destination("Customer 4", "Street 4", 8.0, 5));

        System.out.println("Total Distance of " + route1.getName() + ": " + route1.getTotalDistance() + " km");
        System.out.println("Total Profit of " + route1.getName() + ": EUR " + route1.getTotalProfit());

        System.out.println("Total Distance of " + route2.getName() + ": " + route2.getTotalDistance() + " km");
        System.out.println("Total Profit of " + route2.getName() + ": EUR " + route2.getTotalProfit());
    }
}