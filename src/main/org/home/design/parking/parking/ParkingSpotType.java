package org.home.design.parking.parking;

public enum ParkingSpotType {
    SMALL("small",1,"s000"),
    MEDIUM("medium",2,"m000"),
    LARGE("large",3,"l000"),
    HANDICAPPER("handicapped",0, "h000"),
    XLARGE("xlarge",4,"xl000");

    String slotTypeStr;
    Integer order;
    String slotTypeIdPrefix;

    ParkingSpotType(String slotTypeStr, Integer order, String slotTypeIdPrefix) {
        this.slotTypeStr = slotTypeStr;
        this.order = order;
        this.slotTypeIdPrefix = slotTypeIdPrefix;
    }

    public String getSlotTypeStr() {
        return slotTypeStr;
    }

    public String getSlotTypeIdPrefix() {
        return slotTypeIdPrefix;
    }

    public Integer getOrder() {
        return order;
    }
}
