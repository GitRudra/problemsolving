package org.home.design.bms;

import java.io.Serializable;

public class Seat implements Serializable,Cloneable {
    private String seatId;
    private SeatSpecification specification;
    private boolean available;

    public Seat(String seatId) {
        this.seatId = seatId;
        available = true;
        specification = new SeatSpecification();
    }

    public Seat(String seatId, SeatSpecification specification) {
        this.seatId = seatId;
        this.specification = specification;
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = true;
    }

    public void setUnAvailable() {
        this.available = false;
    }
}
