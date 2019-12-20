package org.home.design.parkinglot;

public class SlotManagerSystem {
    BookedSlotManager bookedSlotManager;
    ParkingManager acquireManager;

    public SlotManagerSystem(int capacity) {
        this.bookedSlotManager = new BookedSlotManager();
        this.acquireManager = new ParkingManager(capacity);
    }

    public String parkVehicle(Vehicle v){
        SpotType minRequiredSpotType = getSlotTypeForVehicleType(v.getType());
        ParkingSpot parkingSpot = acquireManager.getAvailableSlot(minRequiredSpotType);
        bookedSlotManager.addVehicleIntoBookedSlot(v, parkingSpot);
        return parkingSpot.getSpotNumber();
    }

    public void releaseVehicle(String slotNumber, String vehicleNumber) throws Exception {
        ParkingSpot parkingSpot = bookedSlotManager.removeVehicle(vehicleNumber);
    }

    public SpotType getSlotTypeForVehicleType(VehicleType vType){
        SpotType minRequiredSpotType;
        if(vType==VehicleType.CAR){
            minRequiredSpotType = SpotType.MEDIUM;
        }else if(vType == VehicleType.MOTORBIKE){
            minRequiredSpotType = SpotType.SMALL;
        }else if(vType == VehicleType.TRUCK){
            minRequiredSpotType = SpotType.XLARGE;
        }else if(vType == VehicleType.VAN){
            minRequiredSpotType = SpotType.LARGE;
        }else if(vType == VehicleType.ELECTRIC_CAR){
            minRequiredSpotType = SpotType.MEDIUM;
        }else{
            minRequiredSpotType = SpotType.XLARGE;
        }

        return minRequiredSpotType;
    }
}
