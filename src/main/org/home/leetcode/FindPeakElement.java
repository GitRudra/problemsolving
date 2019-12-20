package org.home.leetcode;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int start, int end) {
        int mid = (end + start) / 2;
        if ((mid == 0 || nums[mid] >= nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
            return mid;
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return binarySearch(nums, start, mid - 1);
        } else {
            return binarySearch(nums, mid + 1, end);
        }


    }
}
