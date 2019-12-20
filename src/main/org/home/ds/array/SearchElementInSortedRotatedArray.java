package org.home.ds.array;

/**
 * An element in a sorted array can be found in O(log n) time
 * via binary search. But suppose we rotate an ascending order
 * sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 */
public class SearchElementInSortedRotatedArray {
    private static int searchUtil(int[] input, int key, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(input[mid] == key){
            return mid;
        }

        if(input[start] <= input[mid]){
            if(key>=input[start] && key<= input[mid]){
                return searchUtil(input,key,start,mid-1);
            }else{
                return searchUtil(input,key,mid+1,end);
            }
        }else{
            if(key>=input[mid+1] && key<= input[end]){
                return searchUtil(input,key,mid+1,end);
            }else{
                return searchUtil(input,key,start,mid-1);
            }
        }
    }

    public static int search(int[] nums, int target){
        if(nums == null || nums.length==0){
            return -1;
        }
        return searchUtil(nums,target,0,nums.length-1);
    }
}
