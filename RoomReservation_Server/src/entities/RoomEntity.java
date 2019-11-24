package entities;

public class RoomEntity {
    private int roomNumber;
    private int beds;
    private int floor;
    private int ac;
    private int available;
    private double price;

    public RoomEntity() {}

    public RoomEntity(int roomNumber, int beds, int floor, int ac, int available, double price) {
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

    public int isAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int isAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}