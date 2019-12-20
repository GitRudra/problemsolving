package org.home.design.parkinglot;

import java.util.HashMap;

public class BookedSlotManager {
    private HashMap<String, ParkingSpot> bookedSlot;

    public BookedSlotManager() {
        bookedSlot = new HashMap<>();
    }

    public void addVehicleIntoBookedSlot(Vehicle v, ParkingSpot parkingSpot){
        bookedSlot.put(v.getRegNo(), parkingSpot);
    }

    public ParkingSpot removeVehicle(Vehicle v) throws Exception{
        return removeVehicle(v.getRegNo());
    }

    public ParkingSpot removeVehicle(String vehicleNo) throws Exception{
        if(bookedSlot.containsKey(vehicleNo)){
            return bookedSlot.remove(vehicleNo);
        }else{
            throw new Exception("Invalid vehicle");
        }
    }
}
