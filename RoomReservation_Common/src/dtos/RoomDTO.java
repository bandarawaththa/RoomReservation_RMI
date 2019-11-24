package dtos;

import java.io.Serializable;

public class RoomDTO implements Serializable {
    private int roomNumber;
    private int beds;
    private int floor;
    private boolean ac;
    private boolean available;
    private double price;

    public RoomDTO() {}

    public RoomDTO(int roomNumber, int beds, int floor, boolean ac, boolean available, double price) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.floor = floor;
        this.ac = ac;
        this.available = available;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}