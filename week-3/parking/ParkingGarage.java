package parking;

import java.util.*;

class ParkingGarage {
    private String name;
    private String address;
    private int capacity;
    private List<Car> parkedCars;

    public ParkingGarage(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>();
    }

    public boolean isValidLicensePlate(String licensePlate) {
        return licensePlate.matches("[A-Z]{2}-[A-Z]{2}-\\d{2}");
    }

    public boolean enterGarage(Car car) {
        if (!isValidLicensePlate(car.getLicensePlate())) {
            System.out.println("Invalid license plate!");
            return false;
        }
        if (parkedCars.size() >= capacity) {
            System.out.println("Garage is full!");
            return false;
        }
        long whiteCarCount = parkedCars.stream().filter(c -> c.getColor().equalsIgnoreCase("white")).count();
        if (car.getColor().equalsIgnoreCase("white") && whiteCarCount >= 40) {
            System.out.println("Too many white cars in the garage!");
            return false;
        }
        parkedCars.add(car);
        System.out.println("Car entered: " + car.getLicensePlate());
        return true;
    }

    public boolean exitGarage(String licensePlate) {
        return parkedCars.removeIf(car -> car.getLicensePlate().equalsIgnoreCase(licensePlate));
    }

    public int countCarsByBrand(String brand) {
        return (int) parkedCars.stream().filter(car -> car.getBrand().equalsIgnoreCase(brand)).count();
    }

    public void printGarageStatus() {
        System.out.println("Parking Garage: " + name + " (Capacity: " + capacity + ")");
        System.out.println("Cars currently parked: " + parkedCars.size());
    }
}
