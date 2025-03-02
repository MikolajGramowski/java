package parking;

class Car {
    private String licensePlate;
    private String brand;
    private String color;

    public Car(String licensePlate, String brand, String color) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}
