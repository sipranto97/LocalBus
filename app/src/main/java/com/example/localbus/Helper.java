package com.example.localbus;

public class Helper {
    private double latitude;
    private double longitude;
    private String name;
    private int status;

    public Helper(double latitude, double longitude, String name,int status) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
