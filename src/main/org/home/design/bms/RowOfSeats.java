package org.home.design.bms;

import java.util.List;

public class RowOfSeats {
    private List<Seat> rowOfSeats;
    private String rowId;
    private int numberOfSeats;

    public RowOfSeats(String rowId, int numberOfSeats) {
        this.rowId = rowId;
        this.numberOfSeats = numberOfSeats;
    }

    private void createSeats(){

    }
}
