package org.home.ds.array;


public class MajorityElement {

    private static int findMajorityElement(int[] arr){
        int majIndex = 0;
        int count = 1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == arr[majIndex]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majIndex = i;
                count = 1;
            }
        }
        return arr[majIndex];
    }

    private static boolean isMajorityElement(int[] arr, int majElement){
        int count = 0;
        for(int i= 0;i<arr.length;i++){
            if(arr[i] == majElement){
                count++;
            }
        }
        return count > Math.floor(arr.length/2);
    }

    public static int majorityElement(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int maj = findMajorityElement(arr);
        boolean isMajorityElement = isMajorityElement(arr,maj);
        return isMajorityElement ? maj : -1;
    }
}
