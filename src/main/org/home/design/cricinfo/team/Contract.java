package org.home.design.cricinfo.team;

import java.util.Date;

public class Contract {
    private Date startDate;
    private Date endDate;
    private boolean active;

    public Contract(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean cancelContract(){
        active = false;
        return true;
    }
}
