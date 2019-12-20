package org.home.algo.dp;

public class RodCuttingProblem {

    private int cutRodRecursively(int[] rodPices, int currentPos){
        if(rodPices.length<=0){
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<=currentPos;i++){
            maxValue = Math.max(maxValue, cutRodRecursively(rodPices,currentPos-1-i));
        }
        return maxValue;
    }

    public int getRodCuttingMaxValue(int[] rodValues){
        if(rodValues == null || rodValues.length == 0){
            return Integer.MIN_VALUE;
        }
        return cutRodRecursively(rodValues,rodValues.length-1);
    }

    /*private int getMaximumRodValue(int[] rodPrices){
       *//* int[] value = new int[rodPrices.length+1];
        value[0] = 0;*//*

    }*/
}
