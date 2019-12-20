package org.home.leetcode;

public class FirstMissingPositiveNumber {

    public int firstMissingPositive(int[] nums) {
        int minPositiveNumber = Integer.MAX_VALUE;
        int maxPositiveNumber = Integer.MIN_VALUE;
        int positiveNumberSum = 0;
        for(int x:nums){
            if(x>0){
                positiveNumberSum+=x;
                if(x<minPositiveNumber){
                    minPositiveNumber = x;
                }
                if(x>maxPositiveNumber){
                    maxPositiveNumber = x;
                }
            }

        }
        if(minPositiveNumber>1){
            return 1;
        }
        int missingPositiveNumberSum  = getSum(maxPositiveNumber)- getSum(minPositiveNumber)-positiveNumberSum;
        return 0;



    }

    private int getSum(int x){
        return x*(x+1)/2;
    }

    private int nextPositiveNumber(int[] nums, int firstPositiveNumber){
        return -1;
    }
}
