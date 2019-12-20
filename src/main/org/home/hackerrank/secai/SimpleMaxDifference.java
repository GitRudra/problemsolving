package org.home.hackerrank.secai;

import java.util.List;

public class SimpleMaxDifference {

    public static int maxDifference(List<Integer> nums) {
        if(nums == null || nums.size()<=1){
            return -1;
        }
        int maxDifference = Integer.MIN_VALUE;
        for(int i=1;i<nums.size();i++){
            for(int j=0;j<i;j++){
                if(nums.get(j) <nums.get(i)){
                    if(maxDifference < (nums.get(i) - nums.get(j))){
                        maxDifference = nums.get(i) - nums.get(j);
                    }
                }
            }
        }

        return maxDifference == Integer.MIN_VALUE ? -1 : maxDifference;

    }

    public static int maxDifferenceTwo(List<Integer> nums) {
        int maxDifference = nums.get(1) - nums.get(0);
        int minElement = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) - minElement > maxDifference)
                maxDifference = nums.get(i) - minElement;
            if (nums.get(i) < minElement)
                minElement = nums.get(i);
        }

        return maxDifference <0 ? -1 : maxDifference;

    }
}
