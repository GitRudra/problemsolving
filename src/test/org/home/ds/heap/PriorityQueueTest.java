package org.home.ds.heap;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void testPriorityQueueOneInsert() throws Exception {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

//        int[] input = {11,22,33,44,99,77,66,55,44,66,77,12,23,34,45,56,65,43,32,21,2,3,4,5,6};
        int[] input = {9,8,7,6,5,4,3,2,1};
        int printMinCount = 3;
        for(int i=0;i<input.length;i++){
            priorityQueue.insert(input[i]);
            //if(i%printMinCount == 0){
                System.out.println(priorityQueue.getTop());
            //}
        }
    }
}