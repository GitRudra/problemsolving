package org.home.algo.dp;


public class HouseRobbingProblem {

    /**
     * There are n houses build in a line, each of which contains some value in it.
     * A thief is going to steal the maximal value of these houses,
     * but he can’t steal in two adjacent houses because owner of the stolen houses
     * will tell his two neighbour left and right side. What is the maximum stolen value.
     * Examples:
     *
     * Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
     * Output : 19
     * Thief will steal 6, 1, 8 and 4 from house.
     *
     * Input  : hval[] = {5, 3, 4, 11, 2}
     * Output : 16
     * Thief will steal 5 and 11
     */
    public Integer getMaximumRobbedValue(int[] houseValue){
        if(houseValue == null || houseValue.length == 0){
            return 0;
        }

        int[] dpHval = new int[houseValue.length];
        if(houseValue.length == 1){
            return houseValue[0];
        }
        if(houseValue.length == 2){
            return Math.max(houseValue[0],houseValue[1]);
        }
        dpHval[0] = houseValue[0];
        dpHval[1] = Math.max(houseValue[0], houseValue[1]);
        for(int i=2;i<houseValue.length;i++){
            dpHval[i] = Math.max(houseValue[i]+dpHval[i-2],dpHval[i-1]);
        }

        return dpHval[houseValue.length-1];
    }


    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed.
     * All houses at this place are arranged in a circle.
     * That means the first house is the neighbor of the last one.
     * Meanwhile, adjacent houses have security system connected and
     * it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
     *              because they are adjacent houses.
     *
     * Example 2:
     *
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     * @param houseValue
     * @return
     */
    public int getMaximumRobbedValueCircularArrangementOfHouse(int[] houseValue){
        if(houseValue == null || houseValue.length == 0){
            return 0;
        }

        //If the thief rob 0th house then he cannot rob from 1st house and (n-1)th house
        //So he needs to choose any house between 2nd and (n-2)th
        int d1 = houseValue[0]+getMaxRob(houseValue,2, houseValue.length-2);
        //If the thief don't rob 0th house then he can rob from 1st house and (n-1)th house
        int d2 = getMaxRob(houseValue,1,houseValue.length-1);
        return Math.max(d1,d2);
    }

    private int getMaxRob(int[] input, int start, int end){
        if(start>end){
            return 0;
        }
        int[] dp = new int[input.length];
        for(int i=start;i<=end;i++){
            if(i==start){
                dp[i] = input[i];
            }else if(i==start+1){
                dp[i] = Math.max(input[i],input[i-1]);
            }else{
                dp[i] = Math.max(dp[i-1],dp[i-2]+input[i]);
            }

        }
        return dp[end];
    }
}
