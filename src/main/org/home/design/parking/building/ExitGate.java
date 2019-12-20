package org.home.design.parking.building;

public class ExitGate {
    private String gateId;
    private boolean clearanceStatus;

    public ExitGate(String gateId) {
        this.gateId = gateId;
    }

    public boolean scanTicket(){

        return false;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public boolean isClearanceStatus() {
        return clearanceStatus;
    }

    public void setClearanceStatus(boolean clearanceStatus) {
        this.clearanceStatus = clearanceStatus;
    }
}
