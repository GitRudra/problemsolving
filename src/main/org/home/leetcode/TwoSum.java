package org.home.leetcode;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //TreeSet numbers = new TreeSet(Arrays.asList(nums));
        int[] result = new int[2];
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    found = true;
                    break;
                }

            }
            if (found) {
                break;
            }
        }
        return result;
    }
}
