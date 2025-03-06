package com.example.bikerental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RentalManager manager = new RentalManager();

        Bike bike1 = new Bike("Bike-001");
        Bike bike2 = new Bike("Bike-002");
        Bike bike3 = new Bike("Bike-003");

        manager.addBike(bike1);
        manager.addBike(bike2);
        manager.addBike(bike3);

        Customer c1 = new Customer("Alice", LocalDate.of(2000, 1, 15));
        Customer c2 = new Customer("Bob", LocalDate.of(1990, 3, 10));

        Rental r1 = new Rental(
                c1,
                bike1,
                LocalDateTime.of(2023, 8, 1, 10, 0),
                LocalDateTime.of(2023, 8, 1, 11, 0),
                10.0
        );
        manager.recordRental(r1);

        Rental r2 = new Rental(
                c1,
                bike2,
                LocalDateTime.of(2023, 8, 2, 9, 0),
                LocalDateTime.of(2023, 8, 2, 11, 0),
                60.0
        );
        manager.recordRental(r2);

        Rental r3 = new Rental(
                c2,
                bike1,
                LocalDateTime.of(2023, 8, 3, 12, 0),
                LocalDateTime.of(2023, 8, 3, 13, 30),
                8.0
        );
        manager.recordRental(r3);

        System.out.println("Rentals:");
        for (Rental r : manager.getRentals()) {
            System.out.println("Customer: " + r.getCustomer().getName()
                    + ", Bike: " + r.getBike().getBikeId()
                    + ", Distance: " + r.getKilometersCycled()
                    + " km, Cost: €" + r.calculateCost());
        }

        System.out.println("\nTotal Revenue: €" + manager.getTotalRevenue());

        Customer topPaying = manager.getTopPayingCustomer();
        if (topPaying != null) {
            System.out.println("Top paying customer: " + topPaying.getName());
        }

        List<Bike> maintenanceBikes = manager.getBikesEligibleForMaintenance();
        System.out.println("\nBikes eligible for maintenance:");
        if (maintenanceBikes.isEmpty()) {
            System.out.println("No bikes need maintenance at this time.");
        } else {
            for (Bike b : maintenanceBikes) {
                System.out.println(b);
            }
        }

        System.out.println("\nAll bikes' status:");
        for (Bike b : manager.getBikes()) {
            System.out.println(b);
        }
    }
}