package pizza;

import java.util.ArrayList;
import java.util.List;

class Route {
    private String name;
    private DeliveryDriver driver;
    private List<Destination> destinations;

    public Route(String name, DeliveryDriver driver) {
        this.name = name;
        this.driver = driver;
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination dest) {
        destinations.add(dest);
    }

    public double getTotalDistance() {
        return destinations.stream().mapToDouble(Destination::getDistance).sum();
    }

    public double getTotalRevenue() {
        return destinations.stream().mapToDouble(Destination::getRevenue).sum();
    }

    public double getDeliveryCost() {
        return getTotalDistance() * 0.05;
    }

    public double getTotalProfit() {
        return getTotalRevenue() - driver.getSalaryPerRoute();
    }

    public int getTotalPizzas() {
        return destinations.stream().mapToInt(Destination::getPizzas).sum();
    }

    public String getName() {
        return name;
    }
}