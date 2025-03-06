package com.example.cinema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cinema {
    private List<Room> rooms;

    public Cinema() {
        this.rooms = new ArrayList<>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<String> getMoviesAndAvailability() {
        List<String> infoList = new ArrayList<>();
        for (Room room : rooms) {
            String info = String.format("Room %d: '%s' (Price: %.2f) - Available Seats: %d",
                    room.getRoomNumber(),
                    room.getMovie().getTitle(),
                    room.getMovie().getPrice(),
                    room.getAvailableSeatsCount());
            infoList.add(info);
        }
        return infoList;
    }

    public double getCurrentProfits() {
        double total = 0.0;
        for (Room room : rooms) {
            for (Seat seat : room.getSeats()) {
                if (seat.isReserved()) {
                    total += room.getMovie().getPrice() + seat.getAdditionalCharge();
                }
            }
        }
        return total;
    }

    public boolean reserveSeat(String movieTitle, String seatNumber) {
        for (Room room : rooms) {
            if (room.getMovie().getTitle().equalsIgnoreCase(movieTitle)) {
                for (Seat seat : room.getSeats()) {
                    if (seat.getSeatNumber().equalsIgnoreCase(seatNumber) && !seat.isReserved()) {
                        seat.reserve();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void switchMovies(int roomNumber1, int roomNumber2) {
        Room firstRoom = null;
        Room secondRoom = null;

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber1) {
                firstRoom = room;
            } else if (room.getRoomNumber() == roomNumber2) {
                secondRoom = room;
            }
        }

        if (firstRoom != null && secondRoom != null) {
            Movie temp = firstRoom.getMovie();
            firstRoom.setMovie(secondRoom.getMovie());
            secondRoom.setMovie(temp);
        }
    }

    public void removeAllRoomsWithoutDescription(String phrase) {
        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            boolean allSeatsContainPhrase = room.getSeats().stream()
                    .allMatch(seat -> seat.getDescription().contains(phrase));
            if (!allSeatsContainPhrase) {
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "rooms=" + rooms +
                '}';
    }
}
