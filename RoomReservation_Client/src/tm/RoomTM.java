package tm;

public class RoomTM {
    private int roomNumber;
    private int beds;
    private int floor;
    private boolean ac;
    private boolean available;

    public RoomTM() {}

    public RoomTM(int roomNumber, int beds, int floor, boolean ac, boolean available) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.floor = floor;
        this.ac = ac;
        this.available = available;
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
}