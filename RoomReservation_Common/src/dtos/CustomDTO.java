package dtos;

import java.io.Serializable;

public class CustomDTO implements Serializable {
    private int id;
    private int roomNumber;
    private String reserveDate;
    private String releaseDate;
    private String cusNIC;
    private int adults;
    private int kids;

    public CustomDTO() {}

    public CustomDTO(int id, int roomNumber, String reserveDate, String releaseDate, String cusNIC, int adults, int kids) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.reserveDate = reserveDate;
        this.releaseDate = releaseDate;
        this.cusNIC = cusNIC;
        this.adults = adults;
        this.kids = kids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCusNIC() {
        return cusNIC;
    }

    public void setCusNIC(String cusNIC) {
        this.cusNIC = cusNIC;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }
}