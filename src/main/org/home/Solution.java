package org.home;

public class Solution {
    private String[] tier3 = {"SU","LB","MB","UB","LB","MB","UB","SL"};
    private String[] tier2 = {"SU","LB","UB","LB","UB","SL"};

    public String getSeatPosition(String compType, int seatNumber) throws Exception {

        if(compType == "Tier3" || compType == "Sleeper"){
            return getSeatPositionFor3Tier(seatNumber);
        }else if(compType == "Tier2"){
            return getSeatPositionFor2Tier(seatNumber);
        }else{
            throw new Exception("Invalid Coach Type");
        }
    }

    private String getSeatPositionFor3Tier(int seatNumber){
        return tier3[seatNumber%8];
    }

    private String getSeatPositionFor2Tier(int seatNumber){
        return tier3[seatNumber%6];
    }
}
