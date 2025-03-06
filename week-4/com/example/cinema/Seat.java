package com.example.cinema;

public class Seat {
    private String seatNumber;
    private String description;
    private double additionalCharge;
    private boolean reserved;

    public Seat(String seatNumber, String description, double additionalCharge) {
        this.seatNumber = seatNumber;
        this.description = description;
        this.additionalCharge = additionalCharge;
        this.reserved = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", description='" + description + '\'' +
                ", additionalCharge=" + additionalCharge +
                ", reserved=" + reserved +
                '}';
    }
}
