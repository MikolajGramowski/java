package com.example.cinema;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Movie m1 = new Movie("Romantic Comedy", 10.0);
        Movie m2 = new Movie("Action Blast", 12.0);
        Room r1 = new Room(1, m1);
        Room r2 = new Room(2, m2);
        r1.addSeat(new Seat("A1", "Love Seat", 2.0));
        r1.addSeat(new Seat("A2", "Love Seat", 2.0));
        r1.addSeat(new Seat("A3", "Regular Seat", 0.0));
        r2.addSeat(new Seat("B1", "Regular Seat", 0.0));
        r2.addSeat(new Seat("B2", "Luxurious Recliner", 3.0));
        cinema.addRoom(r1);
        cinema.addRoom(r2);
        System.out.println("Movies and availability before reservation:");
        cinema.getMoviesAndAvailability().forEach(System.out::println);
        boolean reserved = cinema.reserveSeat("Romantic Comedy", "A2");
        System.out.println("\nReservation (A2) for 'Romantic Comedy' successful? " + reserved);
        System.out.println("Current profits: " + cinema.getCurrentProfits());
        cinema.switchMovies(1, 2);
        System.out.println("\nAfter switching movies between rooms 1 and 2:");
        cinema.getMoviesAndAvailability().forEach(System.out::println);
        cinema.removeAllRoomsWithoutDescription("Love Seat");
        System.out.println("\nAfter removing rooms where not all seats contain 'Love Seat':");
        if (cinema.getRooms().isEmpty()) {
            System.out.println("No rooms remain!");
        } else {
            cinema.getRooms().forEach(System.out::println);
        }
    }
}