package org.home.design.parking.ticket;

import org.home.design.parking.parking.ParkingSpotType;

public class ParkingRate {
    //private int hourNumber;
    private Double rate;
    private ParkingSpotType parkingSpotType;

    public ParkingRate(Double rate, ParkingSpotType parkingSpotType) {
        this.rate = rate;
        this.parkingSpotType = parkingSpotType;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
