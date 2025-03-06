package com.example.bikerental;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rental {
    private Customer customer;
    private Bike bike;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double kilometersCycled;

    public Rental(Customer customer, Bike bike, LocalDateTime startTime, LocalDateTime endTime, double kilometersCycled) {
        this.customer = customer;
        this.bike = bike;
        this.startTime = startTime;
        this.endTime = endTime;
        this.kilometersCycled = kilometersCycled;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getKilometersCycled() {
        return kilometersCycled;
    }

    public void setKilometersCycled(double kilometersCycled) {
        this.kilometersCycled = kilometersCycled;
    }

    public double calculateCost() {
        double costPerKm = 0.20;
        double costPerHour = 2.0;

        long totalMinutes = Duration.between(startTime, endTime).toMinutes();
        double hours = totalMinutes / 60.0;

        boolean free30MinApplies = (kilometersCycled <= 50);

        if (free30MinApplies) {
            long paidMinutes = Math.max(0, totalMinutes - 30);
            hours = paidMinutes / 60.0;
        }

        double timeCost = hours * costPerHour;
        double distanceCost = kilometersCycled * costPerKm;

        return timeCost + distanceCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "customer=" + customer.getName() +
                ", bike=" + bike.getBikeId() +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", kilometersCycled=" + kilometersCycled +
                ", cost=€" + calculateCost() +
                '}';
    }
}
