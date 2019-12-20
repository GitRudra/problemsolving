package org.home.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {

    int findPivot(int[] arr, int low, int high) {
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }
        int mid = (high + low) / 2;
        if (mid<high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (low< mid && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[low] > arr[mid]) {
            return findPivot(arr, low, mid - 1);
        }
        return findPivot(arr, mid + 1, high);
    }

    private int binarySearch(int[] arr, int start, int end, int key) {
        if (end < start) {
            return -1;
        }
        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                pos =  mid;
                break;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        return pos;
    }

    public int pivotedBinarySearch(int[] arr, int key) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        int keyPos = -1;
        if(pivot != -1 && arr[pivot] == key){
            return pivot;
        }
        if(arr[0] == key){
            return 0;
        }
        if(arr[arr.length-1] == key){
            return arr.length-1;
        }
        if (pivot == -1) {
            keyPos = binarySearch(arr, 0, arr.length - 1, key);
        } else {
            if (arr[0] < key && arr[pivot] > key) {
                keyPos = binarySearch(arr, 0, pivot, key);
            } else {
                keyPos = binarySearch(arr, pivot + 1, arr.length - 1, key);
            }
        }

        return keyPos;
    }

}
