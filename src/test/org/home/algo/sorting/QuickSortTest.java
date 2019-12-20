package org.home.algo.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void testQuickSortOne() {
        QuickSort<Integer> executor = new QuickSort<>();
        ArrayList<Integer> input = new ArrayList<>();
        int[] inputArray = {2,4,6,8,9,7,5,3,1,11};
        for(int x:inputArray){
            input.add(x);
        }
        executor.quickSort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        for(int x:input){
            System.out.print(x+ " ");
        }
    }
}