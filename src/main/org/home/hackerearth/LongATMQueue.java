package org.home.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class LongATMQueue {

    public static int countGroup(int[] queue){
        if(queue == null || queue.length==0){
            return 0;
        }
        boolean isIncreasing = false;
        int groupCount = 1;
        for(int i = 0;i<queue.length-1;i++){
            if(queue[i]>queue[i+1]){
                groupCount++;
            }
        }
        return groupCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queueLength = Integer.parseInt(sc.nextLine());
        String[] lengths = sc.nextLine().split("\\s");
        sc.close();
        int[] input = new int[queueLength];
        for(int i=0;i<queueLength;i++){
            input[i] = Integer.parseInt(lengths[i]);
        }
        int count = countGroup(input);
        System.out.println(count);

    }
}
