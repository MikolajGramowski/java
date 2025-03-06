package com.example.bikerental;

public class Bike {
    private String bikeId;
    private double totalDistanceTraveled;

    public Bike(String bikeId) {
        this.bikeId = bikeId;
        this.totalDistanceTraveled = 0.0;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        if (totalDistanceTraveled >= 0) {
            this.totalDistanceTraveled = totalDistanceTraveled;
        }
    }

    public void addDistanceTraveled(double distance) {
        if (distance > 0) {
            this.totalDistanceTraveled += distance;
        }
    }

    public boolean isEligibleForMaintenance() {
        return totalDistanceTraveled > 500.0;
    }

    @Override
    public String toString() {
        return String.format("Bike{bikeId='%s', totalDistanceTraveled=%.2f, eligibleForMaintenance=%b}",
                bikeId, totalDistanceTraveled, isEligibleForMaintenance());
    }
}
