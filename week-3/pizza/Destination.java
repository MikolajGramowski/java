package pizza;

class Destination {
    private String name;
    private String address;
    private double distanceFromPrevious;
    private int pizzas;

    public Destination(String name, String address, double distanceFromPrevious, int pizzas) {
        this.name = name;
        this.address = address;
        this.distanceFromPrevious = distanceFromPrevious;
        this.pizzas = pizzas;
    }

    public double getDistance() {
        return distanceFromPrevious;
    }

    public int getPizzas() {
        return pizzas;
    }

    public double getRevenue() {
        return pizzas * 5.0;
    }
}
