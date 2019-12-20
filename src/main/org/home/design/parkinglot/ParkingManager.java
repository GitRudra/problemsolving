package org.home.design.parkinglot;

import java.util.Stack;

//SMALL,MEDIUM,LARGE,HANDICAPPER,XLARGE;
public class ParkingManager {

    private Stack smallSlotStack;
    private Stack mediumSlotStack;
    private Stack largeSlotStack;
    private Stack handicapedSlotStack;
    private Stack xLargeSlotStack;


    public ParkingManager(int capacity) {
        this.smallSlotStack = initSlot(SpotType.SMALL, capacity);
        this.mediumSlotStack = initSlot(SpotType.MEDIUM, capacity);
        this.largeSlotStack = initSlot(SpotType.LARGE, capacity);
        this.handicapedSlotStack = initSlot(SpotType.HANDICAPPER, capacity);
        this.xLargeSlotStack = initSlot(SpotType.XLARGE, capacity);

    }

    private Stack<ParkingSpot> initSlot(SpotType type, int capacity) {
        Stack<ParkingSpot> parkingSpotStack = new Stack();
        while (capacity > 0) {
            parkingSpotStack.push(new ParkingSpot(type.getSlotTypeIdPrefix() + capacity, true, type));
            capacity--;
        }

        return parkingSpotStack;
    }

    public ParkingSpot getAvailableSlot(SpotType type) {
        Integer nextLevel = type.getOrder();
        Stack<ParkingSpot> requiredParkingSpot = null;
        boolean slotFound = false;
        while (nextLevel <= 4 && !slotFound) {
            requiredParkingSpot = getSlotStack(nextLevel);
            if (requiredParkingSpot.isEmpty()) {
                nextLevel++;
            } else {
                slotFound = true;
            }
        }
        ParkingSpot parkingSpot = null;
        if (slotFound) {
            parkingSpot = requiredParkingSpot.pop();
            System.out.println("Required parkingSpot type " + type.getSlotTypeStr() + " found : " + parkingSpot.getSpotType().getSlotTypeStr());

        }
        return parkingSpot;
    }

    public void restoreSlot(ParkingSpot sl) {
        Stack<ParkingSpot> targetStack = getSlotStack(sl.getSpotType().getOrder());
        targetStack.push(sl);
    }

    public Stack<ParkingSpot> getSlotStack(Integer order) {
        Stack<ParkingSpot> requiredParkingSpot = null;
        switch (order) {
            case 1:
                requiredParkingSpot = smallSlotStack;
                break;
            case 2:
                requiredParkingSpot = mediumSlotStack;
                break;
            case 3:
                requiredParkingSpot = largeSlotStack;
                break;
            case 4:
                requiredParkingSpot = xLargeSlotStack;
                break;
            case 0:
                requiredParkingSpot = handicapedSlotStack;
                break;
        }

        return requiredParkingSpot;
    }
}
