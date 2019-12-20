package org.home.design.parkinglot;

import org.home.design.parkinglot.gate.Gate;

import java.util.HashMap;

public class ParkingFloorManager {
    private HashMap<String, Gate> gatesMap;
    private ParkingManager parkingManager;
    private HashMap<String,ParkingSpot> vehicleSpotMap;
    private boolean floorFull;



    public String getParkingSpot(Vehicle vehicle){
        if(floorFull){
            return "No Empty sp[t now try in dofferent floor";
        }else{
            ParkingSpot spot = parkingManager.getAvailableSlot(getSlotTypeForVehicleType(vehicle.getType()));
            vehicleSpotMap.put(vehicle.getRegNo(),spot);
            return spot.getSpotNumber();
        }
    }

    public void removeVehicleFromParking(String registrationNo){
        if(vehicleSpotMap.containsKey(registrationNo)){
            parkingManager.restoreSlot(vehicleSpotMap.get(registrationNo));
        }
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
