package com.example.proiect_sanduandrei_titus;

public class Hotel {
    private String hotelName;
    private String town;
    private String address;

    public Hotel(String hotelName, String town, String address) {
        this.hotelName = hotelName;
        this.town = town;
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
