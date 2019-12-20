package org.home.design.parkinglot;



public class ParkingSlotSystem {
    private SlotManagerSystem slotManager= null;
    public static void main(String[] args) {
        ParkingSlotSystem system = new ParkingSlotSystem(3);
        system.assignCar();
    }

    private void assignCar(){
//        String s = slotManager.parkVehicle(new Car("TS001",VehicleType.CAR));
        System.out.println(slotManager.parkVehicle(new Car("TS001",VehicleType.CAR)));
        System.out.println(slotManager.parkVehicle(new Car("TS002",VehicleType.TRUCK)));
        System.out.println(slotManager.parkVehicle(new Car("TS003",VehicleType.MOTORBIKE)));


    }

    public ParkingSlotSystem(int slotcapacityPerType) {
        slotManager = new SlotManagerSystem(slotcapacityPerType);

    }
}
