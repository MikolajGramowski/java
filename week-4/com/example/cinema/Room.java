package com.example.cinema;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private Movie movie;
    private List<Seat> seats;

    public Room(int roomNumber, Movie movie) {
        this.roomNumber = roomNumber;
        this.movie = movie;
        this.seats = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public int getAvailableSeatsCount() {
        int count = 0;
        for (Seat seat : seats) {
            if (!seat.isReserved()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", movie=" + movie +
                ", seats=" + seats.size() +
                '}';
    }
}
