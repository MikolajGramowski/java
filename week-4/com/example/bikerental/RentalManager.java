package com.example.bikerental;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {
    private List<Rental> rentals;
    private List<Bike> bikes;

    public RentalManager() {
        this.rentals = new ArrayList<>();
        this.bikes = new ArrayList<>();
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public void addBike(Bike bike) {
        bikes.add(bike);
    }

    public void recordRental(Rental rental) {
        rentals.add(rental);
        rental.getBike().addDistanceTraveled(rental.getKilometersCycled());
    }

    public double getTotalRevenue() {
        double total = 0.0;
        for (Rental rental : rentals) {
            total += rental.calculateCost();
        }
        return total;
    }

    public Customer getTopPayingCustomer() {
        double maxSpent = 0.0;
        Customer topCustomer = null;
        for (Rental rental : rentals) {
            double currentCustomerTotal = getTotalSpentByCustomer(rental.getCustomer());
            if (currentCustomerTotal > maxSpent) {
                maxSpent = currentCustomerTotal;
                topCustomer = rental.getCustomer();
            }
        }
        return topCustomer;
    }

    private double getTotalSpentByCustomer(Customer customer) {
        double total = 0.0;
        for (Rental rental : rentals) {
            if (rental.getCustomer().equals(customer)) {
                total += rental.calculateCost();
            }
        }
        return total;
    }

    public List<Bike> getBikesEligibleForMaintenance() {
        List<Bike> eligible = new ArrayList<>();
        for (Bike bike : bikes) {
            if (bike.isEligibleForMaintenance()) {
                eligible.add(bike);
            }
        }
        return eligible;
    }

    @Override
    public String toString() {
        return "RentalManager{" +
                "rentals=" + rentals +
                ", bikes=" + bikes +
                '}';
    }
}
