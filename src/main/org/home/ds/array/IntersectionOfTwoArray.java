package org.home.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArray {

    public static void intersection(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int lastValue=arr1[0];
        List<Integer> intersectedList = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                if(arr1[i] != lastValue || (arr1[i] == lastValue && intersectedList.size()==0)){
                    intersectedList.add(arr1[i]);
                    lastValue = arr1[i];
                }
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                //intersectedList.add(arr1[i]);
                i++;
            }else{
                //intersectedList.add(arr2[j]);
                j++;
            }
        }
        /*if(i==arr1.length){
            for(;j<arr2.length;j++){
                intersectedList.add(arr2[j]);
            }
        }else if(j==arr2.length){
            for(;i<arr1.length;i++){
                intersectedList.add(arr1[i]);
            }
        }*/

        intersectedList.stream().forEach(System.out::print);

    }
}
