package org.home.ds.search;

public class SearchInsertPosition {
    /**
     * Input: , 4
     * Output: 2
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        return binarySearch(nums,0,nums.length-1,target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target){
        int mid ;
        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;

    }
}
