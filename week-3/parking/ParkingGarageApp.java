package parking;

public class ParkingGarageApp {
    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage("Central Parking", "Street", 100);

        Car car1 = new Car("AB-CD-12", "Toyota", "White");
        Car car2 = new Car("XY-ZW-34", "BMW", "Black");

        garage.enterGarage(car1);
        garage.enterGarage(car2);

        garage.printGarageStatus();
        System.out.println("Number of BMWs: " + garage.countCarsByBrand("BMW"));

        garage.exitGarage("AB-CD-12");
        garage.printGarageStatus();
    }
}
