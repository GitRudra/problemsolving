package org.home.design.parkinglot;

public class ParkingSpot {
    private String spotNumber;
    private boolean available ;
    private SpotType spotType;

    public ParkingSpot(String spotNumber, boolean available, SpotType spotType) {
        this.spotNumber = spotNumber;
        this.available = available;
        this.spotType = spotType;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public SpotType getSpotType() {
        return spotType;
    }
}
