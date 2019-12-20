package org.home.design.parking.building;

public class ParkingAttendantPortal {
    private String portalId;
    private ExitGate associatedExitGate;

    public ParkingAttendantPortal(String portalId, ExitGate associatedExitGate) {
        this.portalId = portalId;
        this.associatedExitGate = associatedExitGate;
    }

    public void processPayment(){

    }

    private void calculatePayment(){

    }

    private void setClearanceStatus(){
        associatedExitGate.setClearanceStatus(true);
    }
}
