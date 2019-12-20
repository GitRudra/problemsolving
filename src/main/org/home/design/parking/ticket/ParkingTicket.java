package org.home.design.parking.ticket;

import java.util.Date;

public class ParkingTicket {
    private int ticketNo;
    private Date issuedAt;
    private Date payedAt;
    private String vehicleNo;
    private Double paidAmount;
    private ParkingTicketStatus ticketStatus;

    public ParkingTicket(Date issuedAt, String vehicleNo) {
        this.issuedAt = issuedAt;
        this.vehicleNo = vehicleNo;
        ticketStatus = ParkingTicketStatus.ACTIVE;
    }
}
