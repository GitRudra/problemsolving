package org.home.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class BirthdayCandleOrganizer {
    public static int birthdayCakeCandles(int[] ar) {
        TreeMap<Integer, Integer> candleCountMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        Arrays.stream(ar).forEach(e -> {
            if (candleCountMap.containsKey(e)) {
                candleCountMap.put(e, candleCountMap.get(e) + 1);
            } else {
                candleCountMap.put(e, 1);
            }
        });

        return candleCountMap.get(candleCountMap.firstKey());
    }

   /* public static int birthdayCakeCandles2(int[] ar){
            int maxValue = ar[0];
            int maxValueCount = 0;
            for(int i=1 ; i<ar.length;i++){
                if(ar[i]>maxValue){
                    maxValue = ar[i];
                    maxValueCount++;
                }else if(ar[i] == maxValue){
                    maxValueCount++;
                }else{

                }
            }
            return maxValueCount;
    }*/
}
